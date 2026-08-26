class KthLargest {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    int size = 0;

    public KthLargest(int k, int[] nums) {
        this.size = k;
        for(int num : nums){
            maxHeap.add(num);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
    }
    
    public int add(int val) {
        maxHeap.add(val);

        if(maxHeap.size() > size)
                maxHeap.poll();
        return maxHeap.peek();

        
    }
}
