class Pair{
    int row;
    int col;
    int tm;
    public Pair(int row,int col,int tm){
        this.row=row;
        this.col=col;
        this.tm=tm;
    }
}

class Solution {

    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int cntFresh=0;
        Queue<Pair> q=new LinkedList<>();
        int[] rdir={-1,0,1,0};
        int[] cdir={0,1,0,-1};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) cntFresh++;
            }
        }


        int tm=0;
        int cnt=0;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int t=q.peek().tm;  
            tm=Math.max(t,tm);
            q.remove();


            for(int i=0;i<4;i++){
                int nr=row+rdir[i];
                int nc=col+cdir[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m && vis[nr][nc]==0 && grid[nr][nc]==1){
                    q.add(new Pair(nr,nc,t+1));
                    vis[nr][nc]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh) return -1;
        return tm;
    }
    
}