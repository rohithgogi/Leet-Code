class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n=nums.length;
        int max=0;
        for(int i:nums){
            max=Math.max(max,i);
        }
        int[] freq=new int[max+1];
        for(int x:nums){
            freq[x]++;
        }

        long[] exact=new long[max+1];

        for (int g = max; g >= 1; g--) {

            long cnt = 0;

            // Count numbers divisible by g
            for (int multiple = g; multiple <= max; multiple += g) {
                cnt += freq[multiple];
            }

            // Total pairs divisible by g
            long pairs = cnt * (cnt - 1) / 2;

            // Remove pairs whose gcd is a multiple of g
            for (int multiple = g * 2; multiple <= max; multiple += g) {
                pairs -= exact[multiple];
            }

            exact[g] = pairs;
        }

        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + exact[g];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long k = queries[i] + 1;   // queries are 0-indexed

            int l = 1;
            int r = max;

            while (l < r) {
                int mid = (l + r) / 2;

                if (prefix[mid] >= k)
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[i] = l;
        }
        return ans;

    }
    private int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    
}