class Solution {


    public List<List<Integer>> backTrackSum(int index,int[] candidates, int target,List<Integer> current ,List<List<Integer>> ans){

        if(target == 0){
            ans.add(new ArrayList<>(current));
            return ans;
        }
        if(target < 0)
            return ans;

        for(int i=index;i<candidates.length;i++){
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

        current.add(candidates[i]);
        backTrackSum(i+1,candidates,target-candidates[i],current,ans);
         current.remove(current.size()-1);
        
        }
    
       

        return ans;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        
       return  backTrackSum(0,candidates,target,current,ans);
        
    }
}
