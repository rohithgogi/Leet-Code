class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int ans=Integer.MAX_VALUE;
        Integer[][] dp=new Integer[n][n];

        for(int i=0;i<n;i++){
            dp[n-1][i]=matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=n-1;j++){
                int down=dp[i+1][j];
                int left=(j-1>=0)?dp[i+1][j-1]:(int) 1e9;
                int right=(j+1)<n?dp[i+1][j+1]:(int) 1e9;
                dp[i][j]=matrix[i][j]+Math.min(Math.min(left,right),down);
            }
        }
        for(int i:dp[0]){
            ans=Math.min(ans,i);
        }
        
        // for(int i=0;i<n;i++){
        //     int curr=minPath(matrix,0,i,dp);
        //     ans=Math.min(curr,ans);
        // }
        return ans;

    }
    public int minPath(int[][] matrix,int i,int j,Integer[][] dp){
        if(j<0 || j>matrix.length-1) return (int)1e9;
        if(i==matrix.length-1) return dp[i][j]=matrix[i][j];
        if(dp[i][j]!=null) return dp[i][j];
        int left=matrix[i][j]+minPath(matrix,i+1,j-1,dp);
        int curr=matrix[i][j]+minPath(matrix,i+1,j,dp);
        int right=matrix[i][j]+minPath(matrix,i+1,j+1,dp);

        return dp[i][j]=Math.min(curr,Math.min(left,right));

    }
}