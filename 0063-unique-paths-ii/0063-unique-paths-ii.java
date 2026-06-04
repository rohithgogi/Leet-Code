class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else if(i==0 && j==0){
                    dp[i][j]=1;
                }else{
                    int left=0;
                    int up=0;
                    if(i>0) up= dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j]=left+up;
                }
            }
        }
        return dp[m-1][n-1];

        // for(int i=0;i<m;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return paths(obstacleGrid,m-1,n-1,dp);
    }
    public int paths(int[][] grid,int i,int j,int[][] dp){
        
        if(i<0 || j<0 || grid[i][j]==1) return 0;
        if(i==0 && j==0) return dp[i][j]=1;
        if(dp[i][j]!=-1) return dp[i][j];
        
        
        int left=paths(grid,i,j-1,dp);
        int up=paths(grid,i-1,j,dp);
        return dp[i][j]=left+up;

    }
}