class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        for(int i=0;i<stones.length;i++){
            maxHeap.offer(stones[i]);

        }
        while(maxHeap.size()>1){

            int x = maxHeap.poll();
            int y = maxHeap.poll();
            int z = Math.abs(x - y);
            if(z!=0)
                maxHeap.offer(z);
            

        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
