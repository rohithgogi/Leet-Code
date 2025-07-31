class Solution {
    public boolean predictTheWinner(int[] nums) {
        return helper(nums,0,nums.length-1)>=0;
    }
    static int helper(int[] arr,int s,int e){
        if(s==e){
            return arr[s];
        }
        int pickStart=arr[s]-helper(arr,s+1,e);
        int pickEnd=arr[e]-helper(arr,s,e-1);

        return Math.max(pickStart,pickEnd);
    }
}