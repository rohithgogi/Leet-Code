class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set=new HashSet();
        int[] ans=new int[2];
        for(int i:nums){
            if(set.add(i)){
                set.add(i);
            }else{
                ans[0]=i;
            }
        }for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                ans[1]=i;
            }

        }
        return ans;
    }
    
}