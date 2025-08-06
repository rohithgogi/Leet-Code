class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        boolean[] vis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                int[] res=dfs(i,adj,vis);
                int nodes=res[0];
                int edgesInComponents=res[1]/2;
                if(edgesInComponents==nodes*(nodes-1)/2){
                    count++;
                }
            }
        }
        return count;        
    }
    public int[] dfs(int node, List<List<Integer>> adj, boolean[] vis){
        vis[node]=true;
        int nodes=1;
        int edges=adj.get(node).size();
        for(int i:adj.get(node)){
            if(!vis[i]){
                int[] result =dfs(i,adj,vis);
                nodes+=result[0];
                edges+=result[1];
            }
        }
        return new int[]{nodes,edges};
    }
}