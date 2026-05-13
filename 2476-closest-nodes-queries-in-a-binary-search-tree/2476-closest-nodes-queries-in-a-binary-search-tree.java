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
    List<Integer> list=new ArrayList<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorder(root);
        List<List<Integer>> ans=new ArrayList<>();
        int min=0;
        int max=0;
        for(int q:queries){
            min=floor(q);
            max=ceil(q);
            ans.add(Arrays.asList(min,max));
        }
        return ans;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public int floor(int q){
        int ans=-1;
        int low=0;
        int high=list.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(q>=list.get(mid)){
                ans=list.get(mid);
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    public int ceil(int q){
        int ans=-1;
        int low=0;
        int high=list.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
           
            if(q<=list.get(mid)){
                ans=list.get(mid);
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}