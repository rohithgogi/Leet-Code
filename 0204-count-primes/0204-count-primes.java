class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        int[] arr=new int[n];
        for(int i=2;i<n;i++){
            arr[i]=1;
        }
        arr[0]=arr[1]=0;
        for(int i=2;i*i<=n;i++){
            for(int j=i*i;j<n;j+=i){
                arr[j]=0;
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(arr[i]==1) count++;
        }
        return count;
    }
}