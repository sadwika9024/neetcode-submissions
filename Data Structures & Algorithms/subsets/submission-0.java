class Solution {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public void generateSubsets(int index,List<Integer> subset,int[] nums){

        if(index==nums.length)
        {
            ans.add(new ArrayList<>(subset));
           //ans.add(subset);-- it will always add empty subset
            return ;
        }
        //adding
        subset.add(nums[index]);
        generateSubsets(index+1,subset,nums);
        //backtrack
        subset.remove(subset.size()-1);
        generateSubsets(index + 1, subset, nums);


    }
    public List<List<Integer>> subsets(int[] nums) {

       generateSubsets(0,new ArrayList<>(),nums);
        return ans;
    }
}
