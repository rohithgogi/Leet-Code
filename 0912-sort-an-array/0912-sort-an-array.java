class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(0,nums.length-1,nums);
        return nums;
    }
    public void mergeSort(int s,int e,int[] nums){
        if(s<e){
            int mid=(s+e)/2;
            mergeSort(s,mid,nums);
            mergeSort(mid+1,e,nums);
            merge(nums,s,mid,e);
        }
    }
    public void merge(int[] nums,int s,int mid,int e){
        int ls=mid-s+1;
        int rs=e-mid;
        int[] L=new int[ls];
        int[] R=new int[rs];
        for(int i=0;i<ls;i++){
            L[i]=nums[s+i];
        }
        for(int i=0;i<rs;i++){
            R[i]=nums[mid+1+i];
        }
        int i=0;
        int j=0;
        int k=s;
        while(i<ls && j<rs){
            if(L[i]<R[j]){
                nums[k]=L[i];
                i++;
            }else{
                nums[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<ls){
            nums[k]=L[i];
            i++;
            k++;
        }
        while(j<rs){
            nums[k]=R[j];
            j++;
            k++;
        }
    }
}