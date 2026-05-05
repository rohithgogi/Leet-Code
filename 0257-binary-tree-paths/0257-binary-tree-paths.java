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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> ans=new ArrayList<>();
        if(root==null) return ans;
        paths(root,new StringBuilder(),ans);
        return ans;

    }
    public void  paths(TreeNode root,StringBuilder path,List<String> ans){
        int len=path.length();
        path.append(root.val);
        if(root.left==null && root.right==null){
            ans.add(path.toString());

        }else{
            path.append("->");
            if(root.left!=null) paths(root.left,path,ans);
            if(root.right!=null) paths(root.right,path,ans);
        }
        path.setLength(len);

    }
}