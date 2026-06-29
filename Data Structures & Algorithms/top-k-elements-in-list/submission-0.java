class Solution {
    public int[] topKFrequent(int[] nums, int k) {
// Step 1: Count frequencies
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // Step 3: Keep only top k frequent elements
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            pq.offer(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Extract answer
        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll().getKey();
        }

        return ans;
    }
}
