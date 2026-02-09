class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //case for k=0
        if (k == 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        Map<Integer,Integer> prefixRemainder=new HashMap<>();
        prefixRemainder.put(0,-1);
        int sum=0;
        int rem;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            rem=(sum%k+k)%k;
            if(prefixRemainder.containsKey(rem)){
                if(i-prefixRemainder.get(rem)>=2){
                    return true;
                }
            }else{
                prefixRemainder.put(rem,i);

            }
        }
        return false;
        
    }
}