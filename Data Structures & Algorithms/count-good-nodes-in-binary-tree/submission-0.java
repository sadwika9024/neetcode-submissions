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

class Solution {
    public int goodNodeCount(TreeNode root,int x){
        
        if(root==null)
            return 0;
        
        int current = (root.val>=x) ? 1 : 0;
        x = Math.max(x,root.val);
        int left = goodNodeCount(root.left,x);
        int right = goodNodeCount(root.right,x);
        return left+right+current;

    }
    public int goodNodes(TreeNode root) {

        int x = root.val;
        if(root == null)
            return 0;
       int count = goodNodeCount(root,x);
        return count;
    }
}
