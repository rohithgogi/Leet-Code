class Solution {
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int count=0;
        boolean[][] vis=new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(grid,i,j,vis);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(char[][] grid,int r,int c,boolean[][] vis){
        int rows=grid.length;
        int cols=grid[0].length;

        if(r<0 || c<0 || r>=rows || c>=cols ||grid[r][c]=='0' || vis[r][c]){
            return;
        }
        vis[r][c]=true;

        dfs(grid,r+1,c,vis);
        dfs(grid,r,c+1,vis);
        dfs(grid,r-1,c,vis);
        dfs(grid,r,c-1,vis);

    }
}