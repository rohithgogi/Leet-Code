class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int size=Integer.MAX_VALUE;
        int sum=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            
            while(sum>=target && left<=right){
                size=Math.min(size,right-left+1);
                sum=sum-nums[left];
                left++;
            }
            
        }
        return size==Integer.MAX_VALUE?0:size;
    }
}