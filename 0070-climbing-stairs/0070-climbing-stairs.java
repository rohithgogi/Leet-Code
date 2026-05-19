class Solution {
    
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // return paths(0,n,dp);
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
        
    }
    // public int paths(int steps,int n,int[] dp){
    //     if(steps>n) return 0;
    //     if(steps==n) return 1;
    //     if(dp[steps]!=-1) return dp[steps];
    //     return dp[steps]=paths(steps+1,n,dp)+paths(steps+2,n,dp);
        
    // }
}