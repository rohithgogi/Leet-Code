class Solution {
    private static int MOD=1_000_000_007;
    private int[][][] dp;
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1][201][201];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 200; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        
        return recursion(0,0,0,nums);
    }
    public int recursion(int idx,int gcd1,int gcd2,int[] nums){
        if(idx==nums.length ){
            return (gcd1!=0 && gcd1==gcd2)?1:0;
        }

        if(dp[idx][gcd1][gcd2]!=-1){
            return dp[idx][gcd1][gcd2];
        }

        long ans=0;
        ans=recursion(idx+1,gcd1,gcd2,nums)%MOD;

        int newgcd1=(gcd1==0)?nums[idx]:gcd(gcd1,nums[idx]);
        ans=(ans+recursion(idx+1,newgcd1,gcd2,nums))%MOD;

        int newgcd2=(gcd2==0)?nums[idx]:gcd(gcd2,nums[idx]);
        ans=(ans+recursion(idx+1,gcd1,newgcd2,nums))%MOD;
        return dp[idx][gcd1][gcd2]=(int)ans;
    }
    int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}