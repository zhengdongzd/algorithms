// 1. the recursion logic is quite simpel.
// 2. the index to split the arrays are the key parts. If we dont want to build a new array at each iteration, we may create a new function to
// pass the new index and the original array to the code.
// 3. System.arraycopy() syntax

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;

        if(len==0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);

        int index = 0;
        for(index = 0; index<inorder.length; index++){
            if(inorder[index]==preorder[0])
                break;
        }

        int[] leftpre = new int[index];
        System.arraycopy(preorder, 1, leftpre, 0, index);
        int[] leftin = new int[index];
        System.arraycopy(inorder, 0, leftin, 0, index);
        root.left = buildTree(leftpre, leftin);

        len = len - index - 1;
        int[] rightpre = new int[len];
        System.arraycopy(preorder, index + 1, rightpre, 0, len);
        int[] rightin = new int[len];
        System.arraycopy(inorder, index + 1, rightin, 0, len);
        root.right = buildTree(rightpre, rightin);

        return root;
    }
}