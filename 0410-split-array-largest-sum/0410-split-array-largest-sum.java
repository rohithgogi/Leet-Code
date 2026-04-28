class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;
        for(int i:nums){
            low=Math.max(low,i);
            high+=i;
        }
        int maxsum=Integer.MIN_VALUE;
        while(low<=high){
            int splits=1;
            int currsum=0;
            int mid=low+(high-low)/2;
            for(int i:nums){
                if(currsum+i<=mid){
                    currsum+=i;
                }else{
                    splits++;
                    currsum=i;
                }
            }

            if(splits<=k){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}