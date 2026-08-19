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
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();

        if(root == null)
            return l;

        q.offer(root);
        int x = 1;
        while(!q.isEmpty() ){
            int size = q.size();
            int ans=0;
            while(size>0){
                TreeNode nextUp = q.poll();
                if(nextUp.left != null)
                    q.offer(nextUp.left);
                if(nextUp.right != null)
                    q.offer(nextUp.right);
                ans = nextUp.val;
                size -=1;
            }
           l.add(ans);
        }

        return l;

        
    }
}
