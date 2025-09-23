class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        boolean[] vis=new boolean[n];
        boolean[] pathvis=new boolean[n];
        List<Integer> safeNode=new ArrayList<>();
        int[] check=new int[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,graph,vis,pathvis,check);
            }
        }
        for(int i=0;i<n;i++){
            if(check[i]==1){
                safeNode.add(i);
            }
        }
        Collections.sort(safeNode);
        return safeNode;
    }
    private boolean dfs(int node,int[][] graph,boolean[] vis,boolean[] pathvis,int[] check){
        vis[node]=true;
        pathvis[node]=true;
        check[node]=0;
        for(int it:graph[node]){
            if(!vis[it]){
                if(dfs(it,graph,vis,pathvis,check) == true){
                    check[it]=0;
                    return true;
                }
            }else if(pathvis[it]==true){
                return true;
            }
        }
        check[node]=1;
        pathvis[node]=false;
        return false;
    }
}