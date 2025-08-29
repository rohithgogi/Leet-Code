class Solution {
    public int maxSubArray(int[] nums) {
        
        int sum=nums[0];
        int max=nums[0];
        int j=1;
        while(j<nums.length){
            sum=Math.max(nums[j],sum+nums[j]);
            max=Math.max(max,sum);
            j++;
        }
        return max;
    }
}