class Solution {
    public void rotate(int[] nums, int k) {
        k=k%(nums.length);
        rev(nums,0,nums.length-1);
        rev(nums,0,k-1);
        rev(nums,k,nums.length-1);
        
    }
    public void rev(int[] arr,int s,int e){
        while(s<=e){
            int t=arr[s];
            arr[s]=arr[e];
            arr[e]=t;
            s++;
            e--;
        }
    }
}