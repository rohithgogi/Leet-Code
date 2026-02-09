class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix=new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            prefix[i]=nums[i-1]+prefix[i-1];
        }
        for(int i=0;i<nums.length;i++){
            int left=prefix[i];
            int right;
            if(i==nums.length-1){
                right=0;
            }else{
                right=prefix[nums.length]-prefix[i+1];
            }
            if(right==left){
                return i;
            }
        }
        return -1;
    }
}