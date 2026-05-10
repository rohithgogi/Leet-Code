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
    // long prev=Long.MIN_VALUE;
    // boolean ans=true;
    public boolean isValidBST(TreeNode root) {
        // inorder(root);
        // return ans;
        return validate(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public boolean validate(TreeNode root,int min,int max){
        if(root==null) return true;
        if(root.val<=min || root.val>=max) return false;
        boolean left=validate(root.left,min,root.val);
        boolean right=validate(root.right,root.val,max);
        return left && right;
    }
    // public void inorder(TreeNode root){
    //     if(root==null) return;
    //     inorder(root.left);
    //     if(root.val<=prev){
    //         ans= false;
    //     }else{
    //         prev=root.val;
    //     }
    //     inorder(root.right);
    // }
}