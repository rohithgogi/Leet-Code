class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Integer[][][] dp=new Integer[n][m][m];
        return cherries(0,0,grid[0].length-1,grid,dp);

    }
    public int cherries(int i,int j1,int j2,int[][] grid,Integer[][][] dp){
        if(j1<0 ||j1>grid[0].length-1 || j2<0 ||j2>grid[0].length-1) return Integer.MIN_VALUE;
        if(i==grid.length-1){
            if(j1==j2) return dp[i][j1][j2]=grid[i][j1];
            else return dp[i][j1][j2]=grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=null) return dp[i][j1][j2];
        int max=0;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                if(j1==j2) max=Math.max(max,grid[i][j1]+cherries(i+1,j1+dj1,j2+dj2,grid,dp));
                else max=Math.max(max,grid[i][j1]+grid[i][j2]+cherries(i+1,j1+dj1,j2+dj2,grid,dp));
            }
            dp[i][j1][j2]=max;
        }
        return max;
    }
}