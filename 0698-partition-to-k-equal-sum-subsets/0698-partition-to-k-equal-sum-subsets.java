class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        
        if(sum%k !=0) return false;
        Arrays.sort(nums);
        return backtrack(nums,0,new int[k],k,sum/k);
    }
    public boolean backtrack(int[] nums,int idx,int[] sides,int k,int target){
        if(idx==nums.length) return true;
        for(int i=0;i<k;i++){
            if(sides[i]+nums[idx]>target) continue;
            sides[i]+=nums[idx];
            if(backtrack(nums,idx+1,sides,k,target)) return true;
            sides[i]-=nums[idx];
            if(sides[i]==0) break;
        }
        return false;
    }
    public void reverse(int[] arr){//to avoid pryning
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
}