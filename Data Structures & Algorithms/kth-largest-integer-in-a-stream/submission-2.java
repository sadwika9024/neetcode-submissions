class KthLargest {

    PriorityQueue<Integer> maxHeap ;
    int size = 0;

    public KthLargest(int k, int[] nums) {
        this.size = k;
        this.maxHeap = new PriorityQueue<>();
        for(int num : nums){
            maxHeap.offer(num);
        }

        while(maxHeap.size() > k)
            maxHeap.poll();
    }
    
    public int add(int val) {
        maxHeap.offer(val);

        while(maxHeap.size() > size)
                maxHeap.poll();
        return maxHeap.peek();

        
    }
}
