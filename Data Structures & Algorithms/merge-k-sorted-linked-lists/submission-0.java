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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null ||lists.length == 0 )
            return null ;
        
        return mergeKListsUsingDivideAndConquer(lists,0,lists.length-1);

    }

    private ListNode mergeKListsUsingDivideAndConquer(ListNode[] lists , int start , int end){
        //ideal condition when list sizze is 1
        if(start == end){
            return lists[start];
        }
        //meaning if we have only 2 lists -> it imples merge to sorted lists
        if(start+1 == end){
            return merge2SortedList(lists[start],lists[end]);
        }

        int mid = start+ (end-start)/2;
        ListNode left =  mergeKListsUsingDivideAndConquer(lists,start,mid);
        ListNode right = mergeKListsUsingDivideAndConquer(lists,mid+1,end);
        return merge2SortedList(left,right);

    }

    private ListNode merge2SortedList(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode dummy1 = dummy;
        while(l1!=null && l2!=null){
            int val1 = l1.val;
            int val2 = l2.val;
            if(val1<val2)
            {
                dummy.next = l1;
                l1 = l1.next;
            }
            else{
                dummy.next = l2;
                l2 = l2.next;
            }

            dummy = dummy.next;
        }
         dummy.next = l1!=null ? l1 : l2;
        return dummy1.next;

    }
}
