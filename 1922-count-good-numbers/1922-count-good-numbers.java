class Solution {
    public long MOD=1_000_000_007;
    public int countGoodNumbers(long n) {
        
        long even=(n+1)/2;
        long odd=n/2;

        return (int) (helper(5,even)*helper(4,odd) % MOD);
    }
    public long helper(long x, long n){
        if(n==0){
            return 1;
        }

        long temp=helper(x,n/2);

        if(n%2==0){
            return (temp*temp) % MOD;
        }else{
            return (x*temp*temp) % MOD;
        }

    }
   
}