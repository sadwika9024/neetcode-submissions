class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int index,
                           int[] nums,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // Every state is a valid subset
        ans.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

            // Skip duplicate choices at the same level
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);

            backtrack(i + 1, nums, current, ans);

            current.remove(current.size() - 1);
        }
    }
}