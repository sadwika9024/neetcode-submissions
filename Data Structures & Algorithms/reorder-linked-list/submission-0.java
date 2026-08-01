/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
    intution : 
    Find middle using slow & fast → Reverse the second half → Merge both halves alternately.

*/
class Solution {
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        // Find middle using slow & fast 
        while(fast.next!=null && fast.next.next!=null){
            
            slow = slow.next;
            fast = fast.next.next;
        }


        //Reverse the second half
        ListNode secondHalf = slow.next;
        ListNode prev = null;
        while(secondHalf!=null){
            ListNode temp = secondHalf.next;
            secondHalf.next = prev ;
            prev = secondHalf;
            secondHalf = temp;
        }
        //Merge both halves alternately.
        slow.next = null; 
        // ListNode list1 = head;
        // ListNode list2 = prev;


        ListNode result = new ListNode();
        ListNode dummy  = result;
        while(head!=null && prev!=null){
            
            ListNode next1 = head.next;
            ListNode next2 = prev.next;

            head.next = prev;
            prev.next = next1;

            head = next1;
            prev = next2;
        }

       // return dummy.next;

        
    }
}
