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
 public class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode node,int idx){
        this.node=node;
        this.idx=idx;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        if(root==null) return ans;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            int size=q.size();
            int minIdx=q.peek().idx;
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                int newIdx=q.peek().idx-minIdx;
                TreeNode node=q.poll().node;
                if(i==0) first=newIdx;
                if(i==size-1) last=newIdx;

                if(node.left!=null) q.offer(new Pair(node.left,2*newIdx+1));
                if(node.right!=null) q.offer(new Pair(node.right,2*newIdx+2));
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;

    }
}