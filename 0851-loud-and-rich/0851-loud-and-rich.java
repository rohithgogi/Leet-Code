class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n=quiet.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        for(int[] edge:richer){
            int rich=edge[0];
            int poor=edge[1];
            adj.get(rich).add(poor);
            indegree[poor]++;
        }
        int[] answer=new int[n];
        
        for(int i=0;i<n;i++){
            answer[i]=i;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int richperson=q.peek();
            q.poll();

            for(int poorperson:adj.get(richperson)){
                if(quiet[answer[richperson]]<quiet[answer[poorperson]]){
                    answer[poorperson]=answer[richperson];
                }
                indegree[poorperson]--;
                if(indegree[poorperson]==0){
                    q.add(poorperson);
                }
            }
        }
        return answer;
    }
    
}