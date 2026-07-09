class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int leftmax=0;
        int rightmax=0;
        int ans=0;
        while(left<=right){
            if(leftmax<=rightmax){
                leftmax=Math.max(leftmax,height[left]);
                ans+=leftmax-height[left];
                left++;
            }else{
                rightmax=Math.max(rightmax,height[right]);
                ans+=rightmax-height[right];
                right--;
            }
        }
        return ans;
    }
}