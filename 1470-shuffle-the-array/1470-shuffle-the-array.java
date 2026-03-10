class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans=new int[nums.length];
        int l=0;
        int r=n;
        int i=0;
        while(l<n){
            ans[i]=nums[l];
            i++;
            ans[i]=nums[r];
            i++;
            l++;
            r++;
        }
        return ans;
    }
    
}