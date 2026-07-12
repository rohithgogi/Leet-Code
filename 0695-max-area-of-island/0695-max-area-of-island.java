class Solution {
    private int cnt=0;
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    
                    dfs(i,j,vis,grid);
                    max=Math.max(max,cnt);
                    cnt=0;
                }
            }
        }
        return max;
    }
    public void dfs(int i,int j,boolean[][] vis,int[][] grid){
        vis[i][j]=true;
        cnt++;
        int[] rdir={-1,0,1,0};
        int[] cdir={0,1,0,-1};

        for(int k=0;k<4;k++){
            int nr=i+rdir[k];
            int nc=j+cdir[k];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]==1){
                dfs(nr,nc,vis,grid);
            }
        }
        

    }
}