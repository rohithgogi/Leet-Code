class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int des=n-1;
        for(int i=nums.length-2;i>=0;i--){
            if((i+nums[i])>=des){
                des=i;
            }
        }
        if(des==0){
            return true;
        }
        return false;
    }
}