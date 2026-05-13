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
    
    public int rob(TreeNode root) {
        // if(root==null)  return 0;
        // int take=root.val;
        // if(root.left!=null){
        //     take+=rob(root.left.left);
        //     take+=rob(root.left.right);

        // }
        // if(root.right!=null){
        //     take+=rob(root.right.left);
        //     take+=rob(root.right.right);
        // }
        // int skip=rob(root.left)+rob(root.right);
        // return Math.max(take,skip);
        int[] ans=dfs(root);
        return Math.max(ans[0],ans[1]);

    }
    public int[] dfs(TreeNode root){
        if(root==null) return new int[]{0,0};

        int[] left=dfs(root.left);
        int[] right=dfs(root.right);

        int robCurrent=root.val+left[1]+right[1];

        int skipCurrent=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{robCurrent,skipCurrent};

    }
}