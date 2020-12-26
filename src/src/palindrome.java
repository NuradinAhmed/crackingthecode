import packages.packages;
import packages.packages.LinkedListNode;
import java.util.*;

/*
    Question: Palindrome: Implement a function to check if a linked list is a palindrome.
    Solution: To approach this problem, we can picture a palindrome like 0>1>2>1>0. We know that, since its a palindrome
                the list must be the same backwards and forwards.

                iterative Approach: We want to detect linked lists where the front half of the lst is the reverse of the second half.
                How would we do that ? by reversing the front half of the list. A stack can accomplish this.

                We need to push the first half of the elements onto a stack. We can do this in two different ways, depending
                on whether or not we know the size of the linked list.

                if we know the size of the linked list, we can iterate through the fist half of the elements in a standard for loop,
                pushing each elements onto a stack. we must be careful, of course, to handle the case where the length of the linked list
                is odd. if we dont know the size of the linked list, we can iterate through the linked list, using the fast runner/slow
                runner technique. At each step in the loop, we push the data from the slow runner onto a stack.
                When the fast runner hits the end of the list, the slow runner wil have reached the middle of the linked list.
                By this point, the stack will have all the elements from the front of the linked list, but in reverse order.

                Now, we simply iterate through the rest of the linked list. At each iteration, we compare the node to the top
                of the stack. if we complete the iteration without finding a difference, then the linked list is a palindrome.
 */
public class palindrome {

    static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;


        Stack<Integer> stack = new Stack<Integer>();


        /* Push elements from the first half of the linked list onto a stack. When fast runner(which is moving at 2x speed)
            reaches the end of the linked list, then we know we are at the middle.
         */
        while(fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        /* Has odd number of elements, so skip the middle elements */
        if(fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop().intValue();


            /* if values are different, then its not palindrome */
            if(top != slow.data) {
                return false;
            }
            slow = slow.next;

        }

        return true;


    }




    public static void main(String[] args) {
        int length = 11;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i);
        }
           // nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
//            {
//                if(i >= length / 2) {
//                    nodes[i] = length - i - 1;
//                }
//                nodes[i] = i;
//
//
//
//
//            };

        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }
        //nodes[length - 2].data = 9; // Uncomment to ruin palindrome

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());
        System.out.println(isPalindrome(head));
    }
}
