class Solution {
    private int[] rdir={0,1,0,-1};
    private int[] cdir={1,0,-1,0};

    
    public boolean containsCycle(char[][] grid) {
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j]){
                    if(dfs(i,j,-1,-1,vis,grid)) return true;  
                }
            }
        }
        return false;
    }
    public boolean dfs(int row,int col,int pr,int pc,boolean[][] vis,char[][] grid){
        
        vis[row][col]=true;
        for(int i=0;i<4;i++){
            int nr=row+rdir[i];
            int nc=col+cdir[i];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==grid[row][col]){
                if(!vis[nr][nc]){
                    if( dfs(nr,nc,row,col,vis,grid)) return true;
                }else if(nr!=pr && nc!=pc){
                    return true;
                }
               
            }
        }
        return false;

    }
}