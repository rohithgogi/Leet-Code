class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumEven=0;
        int sumOdd=0;
        for(int i=1;i<=2*n;i++){
            if(i%2==0){
                sumEven+=i;
            }else{
                sumOdd+=i;
            }
        }
        return gcd(sumOdd,sumEven);

    }
    public int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}