class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0;
        for(int i=0;i<=arr.length-k;i++){
            int avg=0;
            int sum=0;
            for(int j=i;j<i+k;j++){
                sum=sum+arr[j];   
            }
            avg=sum/k;
            if(avg>=threshold) count++;
        }
        return count;
    }
}