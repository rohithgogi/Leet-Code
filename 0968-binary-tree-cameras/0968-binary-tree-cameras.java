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

    int cam = 0;

    public int minCameraCover(TreeNode root) {

        if(place(root) == 0){
            cam++;
        }

        return cam;
    }

    public int place(TreeNode root){

        if(root == null) return 2;

        int left = place(root.left);
        int right = place(root.right);

        // child needs camera
        if(left == 0 || right == 0){
            cam++;
            return 1;
        }

        // child has camera
        if(left == 1 || right == 1){
            return 2;
        }

        // current node not covered
        return 0;
    }
}
