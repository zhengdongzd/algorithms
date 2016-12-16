//we should do this in a recursion way, otherwise we have to store its parent which will make
//the logic very confused. since we need to assign the key.parent.right = key.right; not key = key.right; pay
//attenion here the solution always use root.left = not root = which makes senses
//since recursion here, no loops then
//take this function as always returning a whole tree.

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        if(key < root.val){
            // root=root.left; // not the search idea, while think this as a whole tree
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else{
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            } else {
                TreeNode findMin = root.right;
                int val = findMin.val;
                while(findMin!=null){
                    val = findMin.val;
                    findMin = findMin.left;
                }
                root.val = val;
                root.right = deleteNode(root.right, val);
            }

        }
        return root;
    }
}

//************************************

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode realRoot=root;
        TreeNode parentLeft=null;
        TreeNode parentRight=null;

        TreeNode keyNode=null; //key
        if(root==null) return root;

        while(root!=null){
            if(key<root.val) {if(root.left!=null){parentLeft=root;parentRight=null;root=root.left;}} //we are going left
            if(key>root.val) {if(root.right!=null){parentRight=root;parentLeft=null;root=root.right;}} //we are going right
            if(key==root.val) {keyNode=root;break;} //we have found the key
        }

        if(keyNode==null) {return realRoot;} //invalid key

        if(keyNode.left==null&&keyNode.right==null){if(parentLeft!=null){parentLeft.left=null;} else parentRight.right=null;}

        else if((keyNode.left!=null&&keyNode.right==null)||(keyNode.right!=null&&keyNode.left==null)){

            if(keyNode.left!=null){
              TreeNode newNode=keyNode.left;
                     if(parentLeft==null && parentRight==null){return newNode;}
                        else if(parentLeft==null && parentRight!=null){parentRight.right=newNode;}
                            else if(parentLeft!=null && parentRight==null){parentLeft.left=newNode;}
        }
            if(keyNode.right!=null){
               TreeNode newNode=keyNode.right;
                     if(parentLeft==null && parentRight==null){return newNode;}
                        else if(parentLeft==null && parentRight!=null){parentRight.right=newNode;}
                            else if(parentLeft!=null && parentRight==null){parentLeft.left=newNode;}
        }

        }
        else {
            TreeNode min=null;
            min=keyNode.right; parentRight=keyNode; parentLeft=null;
            while(min.left!=null){parentLeft=min; parentRight=null;min=min.left;}
            keyNode.val=min.val;
            if(parentLeft==null) {parentRight.right=null;}
            else if(parentRight==null){parentLeft.left=null;}
       }

     return realRoot;

    }
}