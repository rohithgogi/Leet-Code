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
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxsum;
    }
    public int pathSum(TreeNode node){
        if(node==null) return 0;
        int ls=Math.max(0,pathSum(node.left));
        int rs=Math.max(0,pathSum(node.right));
        maxsum=Math.max(maxsum,node.val+ls+rs);
        
        return node.val+Math.max(0,Math.max(ls,rs));
    }
}