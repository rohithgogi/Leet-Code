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
    public TreeNode markParents(TreeNode root, Map<TreeNode,TreeNode> parent_track,int start){
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode target=null;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.val==start) target=curr;
            if(curr.left!=null){
                parent_track.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                parent_track.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
        return target;
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode> parent_track=new HashMap<>();
        TreeNode target=markParents(root,parent_track,start);
        Queue<TreeNode> q=new LinkedList<>();
        Map<TreeNode,Boolean> vis=new HashMap<>();
        int time=-1;
        q.offer(target);
        vis.put(target,true);
        while(!q.isEmpty()){
            int size=q.size();
            
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null && vis.get(node.left)==null){
                    vis.put(node.left,true);
                    q.offer(node.left);
                }
                if(node.right!=null && vis.get(node.right)==null){
                    vis.put(node.right,true);
                    q.offer(node.right);
                }
                if(parent_track.get(node)!=null && vis.get(parent_track.get(node))==null){
                    vis.put(parent_track.get(node),true);
                    q.offer(parent_track.get(node));
                }
            }
            time++;
        }
        return time;
    }
}