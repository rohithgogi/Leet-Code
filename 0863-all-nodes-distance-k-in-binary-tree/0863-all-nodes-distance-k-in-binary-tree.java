/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParents(TreeNode root,Map<TreeNode,TreeNode> parent_track,TreeNode target){
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current=queue.poll();
            if(current.left!=null){
                parent_track.put(current.left,current);
                queue.offer(current.left);
            }
            if(current.right!=null){
                parent_track.put(current.right,current);
                queue.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_track=new HashMap<>();
        markParents(root,parent_track,target);
        Map<TreeNode,Boolean> vis=new HashMap<>();
        Queue<TreeNode> q=new LinkedList();
        q.offer(target);
        vis.put(target,true);
        int curr_level=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(curr_level==k) break;
            curr_level++;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null && vis.get(node.left)==null){
                    q.offer(node.left);
                    vis.put(node.left,true);
                }
                if(node.right!=null && vis.get(node.right)==null){
                    q.offer(node.right);
                    vis.put(node.right,true);
                }
                if(parent_track.get(node)!=null && vis.get(parent_track.get(node))==null){
                    q.offer(parent_track.get(node));
                    vis.put(parent_track.get(node),true);
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode current=q.poll();
            ans.add(current.val);
        }
        return ans;
    }
}