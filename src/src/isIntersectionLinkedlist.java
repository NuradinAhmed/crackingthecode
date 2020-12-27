/*
    Given two singly linked lists, determine if the two lists intersect. Return the intersection node. Note that the
    intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact
    same node (by reference) as the jth node of the second linked list, then they are intersecting.
 */
import packages.LinkedListNode.AssortedMethods;
import packages.packages.LinkedListNode;

public class isIntersectionLinkedlist {

    public static LinkedListNode findIntersectionNode(LinkedListNode l1head, LinkedListNode l2head) {

        if (l1head == null && l2head == null) return null;


        //create the pointer for each of the list nodes
        LinkedListNode pointer_l1 = l1head;
        LinkedListNode pointer_l2 = l2head;


        /* we are checking to see if the pointer 1 does not equal to pointer 2 then see if pointer 1 is null and if so
            then its in the end of tail of pointer 1 so set to pointer 2 and vice versa
         */

        while (pointer_l1 != pointer_l2) {
            if (pointer_l1 == null) { //== comparison operator - if its equal to null then its at the end of the list in tail.
                pointer_l1 = l2head;

            } else {
                pointer_l1 = pointer_l1.next; //if its not in the tail end then we do regular traverse of the list 1
            }


            //we do the same thing for pointer_l2 as well
            if (pointer_l2 == null) { // if its the end of the list then we set the pointer to the next pointer else traverse as normal
                pointer_l2 = l1head;
            } else {
                pointer_l2 = pointer_l2.next;
            }


        }
        return pointer_l1;

    }



    public static void main(String[] args) {
        /* Create linked list */
        int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        LinkedListNode l1head = AssortedMethods.createLinkedListFromArray(vals);

        int[] vals2 = {12, 14, 15};
        LinkedListNode l2head = AssortedMethods.createLinkedListFromArray(vals2);

        l2head.next.next = l1head.next.next.next;

        System.out.println(l1head.printForward());
        System.out.println(l2head.printForward());


        LinkedListNode intersection = findIntersectionNode(l1head, l2head);

        System.out.println(intersection.printForward());
    }

}

// -1,    -2,    0,    1,    2,    3,    4,    5,    6,    7,    8
//  12,    14,   15,