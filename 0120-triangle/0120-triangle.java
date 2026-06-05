class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        Integer[][] dp=new Integer[n][n];

        for(int i=0;i<n;i++){
            dp[n-1][i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int curr=triangle.get(i).get(j)+dp[i+1][j];
                int left=triangle.get(i).get(j)+dp[i+1][j+1];

                dp[i][j]=Math.min(curr,left);
            }
            
        }
        return dp[0][0];
        // return total(triangle,0,0,dp);
    }
    public int total(List<List<Integer>> triangle,int i,int j,Integer[][] dp){
        if(j<0 || j>triangle.get(i).size()-1) return Integer.MAX_VALUE; 
        if(i==triangle.size()-1) return dp[i][j]=triangle.get(i).get(j);
        
        if(dp[i][j]!=null) return dp[i][j];
        int curr=triangle.get(i).get(j)+total(triangle,i+1,j,dp);
        int right=triangle.get(i).get(j)+total(triangle,i+1,j+1,dp);

        return dp[i][j]=Math.min(curr,right);
    }
}