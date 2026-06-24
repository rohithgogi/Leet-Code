class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int total=0;
        
        for(int i:nums){
            total+=i;
        }
        
        if(total%2!=0) return false;
        int target=total/2;
        // Boolean[][] dp=new Boolean[n][target+1];
        // return recursion(n-1,target,nums,dp);

        boolean[][] dp=new boolean[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(nums[0]<=target){
            dp[0][nums[0]]=true;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean nottake=dp[i-1][j];
                boolean take=false;
                if(nums[i]<=j){
                    take=dp[i-1][j-nums[i]];
                }

                dp[i][j]=take||nottake;
            }
        }
        return dp[n-1][target];
    }
    public boolean recursion(int idx,int target,int[] nums,Boolean[][] dp){
        if(target==0) return true;
        if(idx<0 || target<0) return false;      
        if(dp[idx][target]!=null) return dp[idx][target];
        return dp[idx][target]=recursion(idx-1,target,nums,dp) || recursion(idx-1,target-nums[idx],nums,dp);
    }
}