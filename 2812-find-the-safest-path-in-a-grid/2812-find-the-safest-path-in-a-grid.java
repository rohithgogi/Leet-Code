class Solution {
    int[][] dirs={{0,-1},{-1,0},{0,1},{1,0}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        
        int n=grid.size();
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],-1);
        }
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    dist[i][j]=0;
                    q.offer(new int[]{i,j});
                } 
            }
        }

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];

            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nr<n &&nc>=0 && nc<n && dist[nr][nc]==-1){
                    dist[nr][nc]=dist[r][c]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        int low=0;
        int high=2*(n-1);
        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(canReach(dist,mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    private boolean canReach(int[][] dist,int safe){
        int n=dist.length;
        if(dist[0][0]<safe){
            return false;
        }
        boolean[][] vis=new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        vis[0][0] = true;

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if (r == n - 1 && c == n - 1)
                return true;

            for (int[] d : dirs) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    !vis[nr][nc] &&
                    dist[nr][nc] >= safe) {

                    vis[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
    
    }
    
}