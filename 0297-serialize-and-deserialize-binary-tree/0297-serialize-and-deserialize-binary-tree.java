/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String code="";
        if(root==null) return code;
        code+=String.valueOf(root.val);
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                
                if(node.left!=null){
                    q.offer(node.left);
                    code=code+","+String.valueOf(node.left.val);
                }else{
                    code=code+",#";
                }
                if(node.right!=null){
                    q.offer(node.right);
                    code=code+","+String.valueOf(node.right.val);
                }else{
                    code=code+",#";
                }
            }
        }
        return code;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        int i=1;
        String[] arr=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                TreeNode node=q.poll();
                if(i<arr.length){
                    if(!arr[i].equals("#")){
                        node.left=new TreeNode(Integer.parseInt(arr[i]));
                        q.offer(node.left);
                    }else{
                        node.left=null;
                    }
                    i++; 
                }
                if(i<arr.length){
                    if(!arr[i].equals("#")){
                        node.right=new TreeNode(Integer.parseInt(arr[i]));
                        q.offer(node.right);
                    }else{
                        node.right=null;
                    }
                    i++; 
                }

            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));