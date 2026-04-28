class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int i:weights){
            low=Math.max(low,i);
            high+=i;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int currweight=0;
            int daysUsed=1;
            for(int i:weights){
                if(currweight+i<=mid){
                    currweight+=i;
                }else{
                    daysUsed++;
                    currweight=i;
                }

            }if(daysUsed<=days){
                high=mid-1;
            }
            else {
                low=mid+1;
            
            }
        }
        return low;
    }
}