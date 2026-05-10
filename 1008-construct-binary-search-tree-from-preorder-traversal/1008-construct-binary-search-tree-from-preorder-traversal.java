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
    int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return preorder(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public TreeNode preorder(int[] preorder,int min,int max){
        if(idx==preorder.length) return null;

        int val=preorder[idx];
        if(val>=max || val<=min) return null;

        idx++;
        TreeNode root=new TreeNode(val);

        root.left=preorder(preorder,min,val);
        root.right=preorder(preorder,val,max);
        return root;
    }
}