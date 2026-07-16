class Solution {
    public long gcdSum(int[] nums) {
        long[] prefixGcd=new long[nums.length];
        long max=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max =Math.max(max,nums[i]);
            prefixGcd[i]=gcd(max,nums[i]);   
        }
        Arrays.sort(prefixGcd);
        int start=0;
        int end=nums.length-1;
        long ans=0;
        while(start<end){
            ans+=gcd(prefixGcd[start],prefixGcd[end]);
            start++;
            end--;
        }
        return ans;
    }
    public long gcd(long a,long b){
        while(b!=0){
            long temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}