class Solution {

    int[][][] dirs={
        {},
        {{0,-1},{0,1}},
        {{-1,0},{1,0}},
        {{0,-1},{1,0}},
        {{0,1},{1,0}},
        {{-1,0},{0,-1}},
        {{-1,0},{0,1}}
    };
    public boolean hasValidPath(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];

        return dfs(0,0,grid,vis);

    }

    public boolean dfs(int i,int j, int[][] grid,boolean[][] vis){
        int m=grid.length;
        int n=grid[0].length;
        
        if(i==m-1 && j==n-1) return true;

        vis[i][j]=true;
        int type=grid[i][j];
        for(int[] d:dirs[type]){
            int ni=i+d[0];
            int nj=j+d[1];
            if(ni<0 || nj<0 || ni>=m || nj>=n || vis[ni][nj]==true) continue;
            int nexttype=grid[ni][nj];

            if(canConnectBack(nexttype,d)){
                if(dfs(ni,nj,grid,vis)) return true;
            }

        }
        return false;
    }
    public boolean canConnectBack(int type,int[] d){
        for(int[] nd:dirs[type]){
            if(nd[0]==-d[0] && nd[1]==-d[1]) return true;
        }
        
        return false;
    }
}