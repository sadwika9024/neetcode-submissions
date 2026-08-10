class ListNode{

    int val;
    int key;
    ListNode next;
    ListNode prev;
    ListNode (){ }
    ListNode(int key,int val,ListNode prev,ListNode next){
        this.key=key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
    ListNode(int key,int val){
        this.key = key;
        this.val = val;
    }

}

class LRUCache {

    HashMap<Integer,ListNode> hm ;
    int capacity;
    ListNode head;
    ListNode tail;

    private void addNode(ListNode node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void removeNode(ListNode node) {
       node.prev.next = node.next;
       node.next.prev = node.prev;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();

        head = new ListNode();
        tail = new ListNode();
        head.next = tail ;
        tail.prev = head;
        
    }
    
    public int get(int key) {

         if (!hm.containsKey(key)) {
            return -1;
        }

         ListNode node = hm.get(key);
         removeNode(node);
         addNode(node);


        return node.val;

            
    }
    
    public void put(int key, int value) {

        if(hm.containsKey(key)){
             ListNode node = hm.get(key);
             node.val = value;
             removeNode(node);
             addNode(node);

             return;
        }
        ListNode newNode = new ListNode(key, value);
        hm.put(key,newNode);
        addNode(newNode);
        if (hm.size() > capacity){

            ListNode lru = head.next;
            removeNode(lru);
            hm.remove(lru.key);

        }
    }
        
        
}
    
