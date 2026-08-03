/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        HashMap<Node,Node> hm = new HashMap<>();
        Node tempOfHead = head;

        while(tempOfHead!=null){
            Node dummy = new Node(tempOfHead.val);
            hm.put(tempOfHead,dummy);

            tempOfHead = tempOfHead.next;
        }
        tempOfHead = head; 
        Node copiedNode ;

        while(tempOfHead!=null){

            copiedNode = hm.get(tempOfHead);
            
            copiedNode.next = hm.get(tempOfHead.next);
            copiedNode.random = hm.get(tempOfHead.random);

            tempOfHead = tempOfHead.next;
        
        }
    //    return copiedNode;
    return hm.get(head);
    }
}
