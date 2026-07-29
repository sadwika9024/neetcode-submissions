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

class Solution {
    public ListNode reverseList(ListNode head) {

        //ListNode current = head;
        ListNode prev = null;
       // ListNode next = null;
        
        while(head!=null){
           /*next = current.next ;
           //breaking the chain 
            current.next = prev;

            //setting the new chain 
            prev = current;
            current = next;*/

            ListNode temp = head.next;
            head.next = prev;
            //attaching prev element with current
            prev = head;

            head = temp ;

        }

        return prev;

    }
}
