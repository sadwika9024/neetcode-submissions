/*
maxHeap → smaller half
minHeap → larger half


       SMALLER HALF       |       LARGER HALF
    maxHeap               |      minHeap
   [largest]               |     [smallest]
       ↓                   |         ↓
      5  3  1             |       7  10
*/


class MedianFinder {

    PriorityQueue<Integer> maxHeap ;
    PriorityQueue<Integer> minHeap ;


    public MedianFinder() {

        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        minHeap = new PriorityQueue<>();        
    }
    
    public void addNum(int num) {
        if(maxHeap.size()!=0 && maxHeap.peek()>=num){
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num);
        }

        if(maxHeap.size()>minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }
        else if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        
    }
    
    public double findMedian() {

        if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();

        return (maxHeap.peek()+minHeap.peek())/2.0;


        
    }
}
