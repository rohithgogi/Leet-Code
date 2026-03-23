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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root=build(inorder,0,inorder.length-1,preorder,0,preorder.length-1,inMap);
        return root;
    }
    public TreeNode build(int[] inOrder,int inStart,int inEnd,int[] preOrder,int preStart,int preEnd,Map<Integer,Integer> inMap){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }

        TreeNode root=new TreeNode(preOrder[preStart]);
        int inRoot=inMap.get(root.val);
        int numsLeft=inRoot-inStart;

        root.left=build(inOrder,inStart,inRoot-1,preOrder,preStart+1,preStart+numsLeft,inMap);
        root.right=build(inOrder,inRoot+1,inEnd,preOrder,preStart+numsLeft+1,preEnd,inMap);

        return root;
    }
}