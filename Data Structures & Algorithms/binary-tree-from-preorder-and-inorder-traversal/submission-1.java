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
 Take root from preorder → find root in inorder → inorder tells me how many nodes are in left/right → preorder tells me the order in which those subtree roots appear → recursively construct left, then right.
 */

class Solution {
    int preIndex = 0;
    HashMap<Integer,Integer> hm = new HashMap<>();

    public TreeNode build(int[] preorder,int start,int end){

        if (start > end) 
            return null;

        int value = preorder[preIndex++];
        TreeNode root = new TreeNode(value);

        int index = hm.get(value);

        root.left = build(preorder,start,index-1);
        root.right = build(preorder,index+1,end);

        

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i=0;i<inorder.length;i++)
            hm.put(inorder[i],i);

        return build(preorder,0,inorder.length-1);
        
    }
}
