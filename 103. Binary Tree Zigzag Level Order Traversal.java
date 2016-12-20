// 1. queue.add(null) -- this will also make the size of the queue not equal to zero, so should add 2* and 3* to make sure not
// adding nulls to the queue
// 2. 1* is for the curr.left dont throw out a null error
// 3. Collections.reverse(al); the string has the .reverse() function while the array doesnt

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.add(root);
        boolean ltg = false;
        while(bfs.size()!=0){
            int level = bfs.size();
            ArrayList<Integer> al = new ArrayList<Integer>();
            ltg = !ltg;
            while(level!=0){
                TreeNode curr = bfs.poll();
                if(curr!=null){//1*
                    al.add(curr.val);
                    if(curr.left!=null)//2*
                        bfs.add(curr.left);
                    if(curr.right!=null)//3*
                        bfs.add(curr.right);
                }
                level--;
            }
            if(ltg){
                result.add(al);
            }
            else{
                Collections.reverse(al);
                result.add(al);
            }
        }
        return result;
    }
}