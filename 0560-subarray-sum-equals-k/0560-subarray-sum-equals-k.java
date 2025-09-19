class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixSumCount=new HashMap<>();
        prefixSumCount.put(0,1);
        int prefix=0;
        int count=0;
        
        for(int num:nums){
            prefix+=num;
            if(prefixSumCount.containsKey(prefix-k)){
                count+=prefixSumCount.get(prefix-k);
            }
            prefixSumCount.put(prefix,prefixSumCount.getOrDefault(prefix,0)+1);
        }
        return count;

    }
}