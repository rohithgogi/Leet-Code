class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left=0;
        int right=0;
        long maxsum=0;
        long sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(right=0;right<nums.length;right++){
            sum+=nums[right];
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            
            if(right-left+1>k){
                sum=sum-nums[left];
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            if(map.size()==k && right-left+1 == k){
                maxsum=Math.max(sum,maxsum);
            }
        }
        return maxsum;
    }
    
}