class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum=0;
        Set<Integer> s=new HashSet<>();
        long max=Integer.MIN_VALUE;
        int start=0;
        for(int end=0;end<nums.length;end++){
            if(!s.contains(nums[end])){
                sum=sum+nums[end];
                s.add(nums[end]);

                if((end-start+1)==k){
                    max=Math.max(max,sum);
                    sum=sum-nums[start];
                    s.remove(nums[start]);
                    start++;
                }

            }else{
                while(nums[start]!=nums[end]){
                    sum=sum-nums[start];
                    s.remove(nums[start]);
                    start++;
                }
                start++;
            }
        }
        
        return max;
    }
}