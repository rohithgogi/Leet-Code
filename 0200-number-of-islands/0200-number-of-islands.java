class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    ans++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return ans;

    }
    public void dfs(int row,int col,char[][] grid,boolean[][] vis){
        vis[row][col]=true;

        int[] rdir={-1,0,1,0};
        int[] cdir={0,1,0,-1};

        for(int i=0;i<4;i++){
            int nr=row+rdir[i];
            int nc=col+cdir[i];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]=='1' ){
                dfs(nr,nc,grid,vis);
            }
        }

    }
}