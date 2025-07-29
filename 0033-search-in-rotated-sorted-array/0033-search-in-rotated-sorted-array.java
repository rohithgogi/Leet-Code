class Solution {
    public int search(int[] nums, int target) {
        return recSearch(nums,target,0,nums.length-1);
    }
    static int recSearch(int[] arr,int t,int s,int e){

        if(s>e){
            return -1;
        }
        int m=s+(e-s)/2;
        if(arr[m]==t){
            return m;
        }
        if(arr[s]<=arr[m]){
            if(t>=arr[s] && t<=arr[m]){
                return recSearch(arr,t,s,m-1);
            }else{
                return recSearch(arr,t,m+1,e);
            }
        }
        if(t>=arr[m] && t<=arr[e]){
            return recSearch(arr,t,m+1,e);
        }
        return recSearch(arr,t,s,m-1);
    }
}