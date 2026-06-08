class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] dup=new int[nums.length];
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                dup[idx++]=nums[i];
                
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==pivot ){
                dup[idx++]=nums[i];
               
            }   
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>pivot){
                dup[idx++]=nums[i];
               
            }   
        }
       
        
        return dup;
    }
}