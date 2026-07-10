class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans=0;
        int n=isConnected.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,adj,vis);
                ans++;
            }
        }
        return ans;
        
    }
    public void dfs(int node,List<List<Integer>> adj,boolean[] vis){
        vis[node]=true;
        for(int i:adj.get(node)){
            if(!vis[i]){
                dfs(i,adj,vis);
            }
        }
    }
}