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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxSum;
    }
    public int pathSum(TreeNode root) {
        if(root==null) return 0;

        int ls=pathSum(root.left);
        int rs=pathSum(root.right);
        if(ls<0) ls=0;
        if(rs<0) rs=0;
        maxSum=Math.max(maxSum,ls+rs+root.val);

        return root.val+Math.max(ls,rs);
    }

}