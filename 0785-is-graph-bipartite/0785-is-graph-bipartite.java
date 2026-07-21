class Solution {
    public boolean isBipartite(int[][] graph) {

        int[] color=new int[graph.length];
        Arrays.fill(color,-1);
        
        for(int i=0;i<graph.length;i++){
            if(color[i]== -1){
                if(bfs(i,graph,color)==false) return false; 
            }
            
        }
        return true;
    }
    public boolean bfs(int start,int[][] graph,int[] color){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        color[start]=0;

        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            
            for(int i:graph[node]){
                if(color[i]==-1){
                    color[i]=1-color[node];
                    q.add(i);
                }else if(color[i]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    
}