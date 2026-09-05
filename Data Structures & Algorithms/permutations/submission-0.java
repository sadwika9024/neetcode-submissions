class Solution {

    public void backtrack(int[] nums,
                        List<Integer> current,
                        boolean[] used,
                        List<List<Integer>> ans){


        if(current.size() == nums.length)
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        

        for(int i=0;i<nums.length;i++){
            
            if(used[i]==false){
                used[i] = true;
                current.add(nums[i]);
                backtrack(nums,current,used,ans);
                used[i] = false;
                current.remove(current.size()-1);
            }
            

        }

    }

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> current = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,current,used,ans);
        return ans;

        
    }
}
