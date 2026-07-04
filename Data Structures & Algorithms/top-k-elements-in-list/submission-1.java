class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> qu = new PriorityQueue<>(k, (a, b) -> a.getValue() - b.getValue());
        for(int num : nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){

            qu.offer(entry);

            if(qu.size()>k)
            {
                 qu.poll();
            }
        }

        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = qu.poll().getKey();
        }

        return ans;
        
    }
}
