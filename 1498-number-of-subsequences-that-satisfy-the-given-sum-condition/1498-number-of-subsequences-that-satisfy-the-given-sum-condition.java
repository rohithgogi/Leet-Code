class Solution {
    private long MOD=1_000_000_007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        long[] pow=new long[n];
        pow[0]=1;
        for(int i=1;i<n;i++){
            pow[i]=(pow[i-1]*2)%MOD;
        }
        long ans=0;
        int left=0;
        int right=n-1;
        while(left<=right){
            if(nums[left]+nums[right]<=target){
                ans=(ans+pow[right-left])%MOD;
                left++;
            }else{
                right--;
            }
        }
        return (int) ans;        
    }
    
}