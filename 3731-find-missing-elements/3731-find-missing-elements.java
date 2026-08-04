class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set=new HashSet();
        for(int i:nums){
            set.add(i);
        }
        
        Arrays.sort(nums);
        List<Integer> ans=new ArrayList<>();
        for(int i=nums[0];i<nums[nums.length-1];i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}