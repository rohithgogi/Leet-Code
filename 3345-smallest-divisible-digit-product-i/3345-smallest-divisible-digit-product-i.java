class Solution {
    public int smallestNumber(int n, int t) {
       for(int i=n;;i++){
        int mul=prod(i);
        if(mul%t==0) return i;
       } 
       
    }
    public int prod(int n){
        int ans=1;
        while(n>0){
            int digit=n%10;
            ans=ans*digit;
            if(ans==0) break;
            n=n/10;
        }
        return ans;

    }

}