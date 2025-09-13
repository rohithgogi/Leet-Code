class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int count=0;
        for(int j=0;j<m;j++){
            if(!vis[0][j] && grid[0][j]==1){
                dfs(grid,vis,0,j);
            }
            
        }
        for(int i=0;i<n;i++){
            if(!vis[i][m-1] && grid[i][m-1]==1){
                dfs(grid,vis,i,m-1);
            }
            
        }
        for(int j=m-1;j>=0;j--){
            if(!vis[n-1][j] && grid[n-1][j]==1){
                dfs(grid,vis,n-1,j);
            }
        }
        for(int i=n-1;i>=0;i--){
            if(!vis[i][0] && grid[i][0]==1){
                dfs(grid,vis,i,0);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
        
    }
    public void dfs(int[][] grid,boolean[][] vis,int r,int c){
        vis[r][c]=true;
        int[] rdir={0,-1,0,1};
        int[] cdir={1,0,-1,0};
        for(int i=0;i<4;i++){
            int nr=r+rdir[i];
            int nc=c+cdir[i];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1 && !vis[nr][nc]){
                dfs(grid,vis,nr,nc);
            }
        }
    }
}