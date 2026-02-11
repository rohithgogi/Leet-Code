class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        /*
        for(int i=0;i<nums.length;i++){
            int prod=1;
            for(int j=i;j<nums.length;j++){
                prod=prod*nums[j];

                max=Math.max(prod,max);
            }
        }
        return max;
        */

        int pref=1;
        int suff=1;
        for(int i=0;i<nums.length;i++){
            if(pref==0) pref=1;
            if(suff==0) suff=1;

            pref=pref*nums[i];
            suff=suff*nums[nums.length-i-1];
            max=Math.max(max,Math.max(pref,suff));
        }
        return max;
    }
}