class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n1=nums[0];
        int n2=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            int n3=nums[i];
            if(n3<=n1) n1=n3;
            else if(n3<=n2) n2=n3;
            else return true;
        }
        return false;
    }
}