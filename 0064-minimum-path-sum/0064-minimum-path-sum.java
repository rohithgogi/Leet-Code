class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return path(grid,m-1,n-1,dp);
        
    }
    public int path(int[][] grid,int i,int j,int[][] dp){
        if(i==0 && j==0) return dp[i][j]=grid[i][j];
        if(i<0 || j<0) return (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int left=grid[i][j]+path(grid,i,j-1,dp);
        int up=grid[i][j]+path(grid,i-1,j,dp);

        return dp[i][j]=Math.min(left,up);

    }
}