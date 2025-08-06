class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int count=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                count++;
                dfs(i,vis,isConnected);
            }
        }
        return count;
    }
    public void dfs(int node,boolean[] vis,int[][] isConnected){
        vis[node]=true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[node][i]==1 && !vis[i]){
                dfs(i,vis,isConnected);
            }
        }
    }
}