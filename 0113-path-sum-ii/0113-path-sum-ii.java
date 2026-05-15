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
    List<List<Integer>> ans =new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return ans;
        preorder(root,new ArrayList<>(),0,targetSum);
        return ans;
    }
    public void preorder(TreeNode root,List<Integer> list,int sum,int target){
        if(root==null) return;
        sum+=root.val;
        list.add(root.val);
        if(root.left==null && root.right==null && sum==target){
            ans.add(new ArrayList<>(list));
            
        }
        
        preorder(root.left,list,sum,target);
        preorder(root.right,list,sum,target);
        list.remove(list.size()-1);
    }
}