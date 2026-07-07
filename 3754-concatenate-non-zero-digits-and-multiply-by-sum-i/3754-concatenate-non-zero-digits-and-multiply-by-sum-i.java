class Solution {
    public long sumAndMultiply(int n) {
        int temp=n;
        int sum=0;
        int x=0;
        while(temp!=0){
            int digit=temp%10;
            if(digit!=0){
                x=x*10+digit;
                sum+=digit;
            }
            temp=temp/10;
        }
        if(x==0) return 0;
        int rev=0;
        while (x > 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10;
        }
        return (long)rev* (long) sum;
    }
}