class Solution {
    public boolean containsCycle(char[][] grid) {
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j]){
                    if(dfs(i,j,-1,-1,grid,vis)) return true;;
                }
            }
        }
        return false;
    }
    public boolean dfs(int r,int c, int pr,int pc, char[][] grid, boolean[][] vis){
        vis[r][c]=true;
        int rdir[]={0,-1,0,1};
        int cdir[]={-1,0,1,0};

        for(int i=0;i<4;i++){
            int nr=r+rdir[i];
            int nc=c+cdir[i];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[r][c]==grid[nr][nc] ){
                if(!vis[nr][nc]){
                    if(dfs(nr,nc,r,c,grid,vis)) return true;
                }else if((nr!=pr) && (nc!=pc)){
                    return true;
                }
            }
        }
        return false;
    }
}