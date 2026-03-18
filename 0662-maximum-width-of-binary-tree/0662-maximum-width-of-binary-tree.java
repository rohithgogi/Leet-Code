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

class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode node,int idx){
        this.node=node;
        this.idx=idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int nmin=q.peek().idx;
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                int currId=q.peek().idx-nmin;
                TreeNode node=q.poll().node;
                if(i==0) first=currId;
                if(i==size-1) last=currId;
                if(node.left!=null){
                    q.offer(new Pair(node.left,2*currId+1));
                }if(node.right!=null) q.offer(new Pair(node.right,2*currId+2));
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}