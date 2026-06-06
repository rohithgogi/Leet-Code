class Solution {
    public int[] leftRightDifference(int[] nums) {
        int total=0;
        int[] prefix=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            prefix[i]=total-nums[i];
        }
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=Math.abs(2*prefix[i]+nums[i]-total);
        }
        return ans;
    }
}