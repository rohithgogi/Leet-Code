class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> remMap=new HashMap<>();
        remMap.put(0,1);
        int count=0;
        int sum=0;
        int rem;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            rem=(sum%k + k) % k;

            if(remMap.containsKey(rem)){
                count+=remMap.get(rem);
            }
            remMap.put(rem,remMap.getOrDefault(rem,0)+1);
        
        }
        return count;
    }
}