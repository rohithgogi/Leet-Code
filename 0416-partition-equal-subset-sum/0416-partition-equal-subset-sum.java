class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int total=0;
        
        for(int i:nums){
            total+=i;
        }
        Boolean[][] dp=new Boolean[n][total];
        if(total%2!=0) return false;
        return recursion(n-1,total/2,nums,dp);
    }
    public boolean recursion(int idx,int target,int[] nums,Boolean[][] dp){
        if(target==0) return true;
        if(idx<0 || target<0) return false;      
        if(dp[idx][target]!=null) return dp[idx][target];
        return dp[idx][target]=recursion(idx-1,target,nums,dp) || recursion(idx-1,target-nums[idx],nums,dp);
    }
}