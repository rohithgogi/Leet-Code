class Solution {
    private int maxCycle=-1;
    public int longestCycle(int[] edges) {
        int n=edges.length;
        int max=-1;
        int[] nodestep=new int[n];
        Arrays.fill(nodestep,-1);
        boolean[] vis=new boolean[n];
        boolean[] pathvis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,edges,vis,pathvis,nodestep,0);
            }
            
        }
        return maxCycle;
    }
    private void dfs(int node,int[] edges,boolean[] vis,boolean[] pathvis,int[] nodestep,int step){
        vis[node]=true;
        pathvis[node]=true;
        nodestep[node]=step;

        int neighbour=edges[node];
        if(neighbour!=-1){
            if(!vis[neighbour]){
                dfs(neighbour,edges,vis,pathvis,nodestep,step+1);
            }
            else if(pathvis[neighbour]){
                maxCycle=Math.max(maxCycle,step-nodestep[neighbour]+1);
            
            }
        }
        pathvis[node]=false;
    
    }
}