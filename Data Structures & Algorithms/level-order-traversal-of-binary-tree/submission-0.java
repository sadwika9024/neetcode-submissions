/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 /*

 Create a new row
    ↓
Process all nodes belonging to this level
    ↓
Add their values to row
    ↓
Add row to ans


 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        if(root == null)
            return ans;

        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            while(size>0){
                TreeNode nextUp = q.poll();
                if(nextUp.left != null)
                    q.offer(nextUp.left);
                if(nextUp.right != null)
                    q.offer(nextUp.right);

                level.add(nextUp.val);
                
                size = size-1;
            }
            ans.add(level);
        }
       
        

        return ans;
    }
}
