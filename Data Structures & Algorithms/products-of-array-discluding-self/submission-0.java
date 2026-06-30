class Solution {
    public int[] productExceptSelf(int[] nums) {

       int [] prefixProd = new int[nums.length];
       int [] suffixprod = new int[nums.length];
       int [] ans = new int[nums.length];

        prefixProd[0] = nums[0];
       for(int i=1;i<nums.length;i++){
            prefixProd[i] = prefixProd[i-1] * nums[i];
       }

       suffixprod[nums.length - 1] = nums[nums.length - 1];
        for(int i=nums.length-2;i>=0;i--){
            suffixprod[i] = suffixprod[i+1] * nums[i];
        }

        ans[0] = suffixprod[1];
        ans[nums.length - 1] = prefixProd[nums.length - 2];
        for(int i=1;i<nums.length - 1;i++){
            ans[i] = prefixProd[i-1]*suffixprod[i+1];
        }
        

        return ans;
        
    }
}  
