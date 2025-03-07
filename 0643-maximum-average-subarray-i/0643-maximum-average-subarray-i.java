class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double wAvg=0;
        
        for(int i=0;i<k;i++){
            wAvg=wAvg+nums[i];
        }
        double mAvg=wAvg/k;
        for(int i=k;i<nums.length;i++){
            wAvg=wAvg+nums[i]-nums[i-k];
            mAvg=Math.max(wAvg/k,mAvg);
        }
        return mAvg;
    }
}