class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+2];
        if(n<=1) return nums[0];

        for(int i=n-2;i>=0;i--){
            dp[i]=Math.max(nums[i]+dp[i+2],dp[i+1]);

        }
      
        for(int i=n-1;i>0;i--){
            dp[i]=Math.max(nums[i]+dp[i+2],dp[i+1]);
        }
        return Math.max(dp[1],dp[0]);
    }
}