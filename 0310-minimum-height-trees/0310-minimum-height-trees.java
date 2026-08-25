
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] degree=new int[n];
        for(int i=0;i<n;i++){
            degree[i]=adj.get(i).size();
        }


        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                q.add(i);
            }
        }

        while(n>2){
            int size=q.size();
            n=n-size;

            for(int i=0;i<size;i++){
                int leaf=q.poll();
                for(int it:adj.get(leaf)){
                    degree[it]--;
                    if(degree[it]==1){
                        q.add(it);
                    }
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        return ans;
    }
    
}