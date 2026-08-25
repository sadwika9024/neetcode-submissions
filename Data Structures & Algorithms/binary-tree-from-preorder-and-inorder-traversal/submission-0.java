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
    public int findIndex(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i; // Found: returns current index
        }
    }
    return -1; // Not found
    }
    public TreeNode build(int[] preorder, int[] inorder,int preorderStart,int preorderEnd,int inorderStart,
    int inorderEnd){

        if (preorderStart > preorderEnd ||inorderStart > inorderEnd) {
             return null;
        }




        TreeNode root = new TreeNode(preorder[preorderStart]);
        int index = findIndex(inorder,preorder[preorderStart]);




        //System.out.println(index);
        int leftSize = index - inorderStart;
        root.left = build(preorder,inorder,
                        preorderStart+1,preorderStart+leftSize,
                        inorderStart,index-1);

        root.right = build(preorder,inorder,
                        preorderStart+leftSize+1,preorderEnd,
                        index+1,inorderEnd);


        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //int n = preorder.length();
        if(preorder.length<=0)
            return new TreeNode();
        
        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        
    }
}
