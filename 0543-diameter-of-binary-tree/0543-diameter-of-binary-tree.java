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
    private int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return max;

    }
    public int diameter(TreeNode node){
        if(node==null) return 0;

        int lh=diameter(node.left);
        int rh=diameter(node.right);
        max=Math.max(max,lh+rh);

        return 1+Math.max(lh,rh);
        
    }
}