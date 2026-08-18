class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis=new int[graph.length];
        int[] pathvis=new int[graph.length];
        int[] check=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(vis[i]==0){
                dfsCheck(i,graph,vis,pathvis,check);
            }
        }
        List<Integer> safeNodes=new ArrayList<>();
        for(int i=0;i<check.length;i++){
            if(check[i]==1){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
    public boolean dfsCheck(int node,int[][] graph,int[] vis,int[] pathvis,int[] check){
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;

        for(int i:graph[node]){
            if(vis[i]==0){
                if(dfsCheck(i,graph,vis,pathvis,check)==true){
                    return true;
                }
            }else if(pathvis[i]==1){
                return true;
            }
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }
}