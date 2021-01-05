/*
    Loop Detection: Given a linked list which might contain a loop, implement an algorithm that returns the node
                    at the beginning of the loop (if exists).\
                    Ex: Input: A > B > C > D > E > C [the same C as earlier]
                        Output: C
 */


import packages.packages;

import java.util.LinkedList;

public class loopDetection {

    packages.LinkedListNode FindBeginning(packages.packages.LinkedListNode head) {
        packages.packages.LinkedListNode slow = head;
        packages.packages.LinkedListNode fast = head;


        /* Find meeting point. This will be Loop_Size - K  steps into the linked list. */
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                //collision
                break;
            }
        }


        /* Error check - no meeting point, and therefore no loop */
        if(fast == null || fast.next == null){
            return null;

        }

        /* Move slow to Head. Keep fast at Meeting Point. Each are K steps from the Loop Start.
            If they move at the same pace, they must meet at loop start.
         */

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }


        /* Both now point to the start of the loop */
        return fast;

    }
}
