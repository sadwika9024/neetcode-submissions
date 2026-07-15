class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[0]-a[0]
        );
        int [] ans = new int[nums.length-k+1];
        int j=0;
        /*
            for every i
                add (value,index)
                while(top index is outside window)
                    remove top
                if(window formed)
                    answer = top value
        */


        for(int i=0;i<nums.length;i++){
            pq.offer(new int[]{nums[i],i});
            while(!pq.isEmpty() &&pq.peek()[1] <=i-k)
            {
                pq.poll();
            }
            if(i>=k-1){
                ans[j] = pq.peek()[0];
                j++;
            }
           
             
        }
        return ans;
    }
}
