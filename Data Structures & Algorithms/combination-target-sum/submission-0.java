/*
### Short Algorithm — Combination Sum

1. Start recursion with `index = 0`, `remaining = target`, and an empty `current`.
2. If `remaining == 0`, add `current` to `ans`.
3. If `remaining < 0` or `index == nums.length`, stop.
4. **Take** `nums[index]`:

   * Add it to `current`.
   * Recurse with the **same index** and `remaining - nums[index]`.
   * Remove it from `current` (backtrack).
5. **Skip** `nums[index]`:

   * Recurse with `index + 1` and the **same remaining**.
6. Return `ans`.

**Key point:**
`Take → same index` because numbers can be reused.
`Skip → index + 1` because we move to the next number.


*/

class Solution {


    public List<List<Integer>> backtrack(int[] nums, int index,int target
                                                                    , List<Integer> current,List<List<Integer>> ans)
                                                                    {
        
        if(target == 0)
        {
            ans.add(new ArrayList<>(current));
            return ans;
        }
       if (target < 0 || index == nums.length) {
             return ans;
        }
        current.add(nums[index]);
        backtrack(nums,index, target - nums[index] ,current,ans);


        current.remove(current.size()-1);

        backtrack(nums,index+1,target ,current,ans);
        return ans;
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<>();

        backtrack(nums, 0, target, current, ans);
        return ans;


    }
}
