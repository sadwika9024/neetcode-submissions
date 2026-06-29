class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> hp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int required = target - nums[i];
            if(hp.containsKey(required))
                return new int[]{hp.get(required),i};
            hp.put(nums[i],i);
            
        }

    return new int[]{-1,-1};
    }
}
