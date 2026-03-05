class Solution {
    public int removeElement(int[] nums, int val) {
       int s=0;
       int count=0;
       int e=nums.length-1;
       while(e>=0 && nums[e]==val){
            e--;
            count++;
       }
       while(s<=e){
        if(nums[s]==val){
            count++;
            swap(nums,s,e);
            e--;
        }else{
            s++;
        }
        
       }
       return nums.length-count;
    }
    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}