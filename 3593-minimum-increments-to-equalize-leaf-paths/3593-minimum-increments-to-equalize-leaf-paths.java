class Solution {
    int count=0;
    public int minIncrease(int n, int[][] edges, int[] cost) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] arr:edges){
            graph[arr[0]].add(arr[1]);
            graph[arr[1]].add(arr[0]);
        }
        dfs(0,-1,graph,cost);
        return count;
    }
    public int dfs(int node,int parent,List<Integer>[] graph, int[] cost){
        if(graph[node].isEmpty()) return cost[node];
        
        int high=Integer.MIN_VALUE;
        List<Integer> childcosts=new ArrayList<>();
        for(int child:graph[node]){
            if(child==parent) continue;
            int costs=dfs(child,node,graph,cost);
            childcosts.add(costs);
            
            high=Math.max(costs,high);
        }
        for(int i:childcosts){
            if(i!=high) count++;
        }
     
        return high+cost[node];
    }

}