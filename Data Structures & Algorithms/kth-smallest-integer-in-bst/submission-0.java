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
    int counter=0;
    int answer = 0;
    public void ksmall(TreeNode root, int k)
    {
        if(root==null)
            return ;
        
        if(root.left!=null)
            ksmall(root.left,k);


        counter++;
        if(k==counter)
            answer = root.val;
        

        if(root.right!=null)
            ksmall(root.right,k);
        
    }
    public int kthSmallest(TreeNode root, int k) {

        if(root==null)
            return 0;

        ksmall(root,k); 
        return answer;        

        
    }
}
