class Solution {
    public int minFlips(String s) {
        StringBuilder p1=new StringBuilder();
        StringBuilder p2=new StringBuilder();
        for(int i=0;i<2*s.length();i++){
            if(i%2==0){
                p1.append('1');
                p2.append('0');
            }else{
                p1.append('0');
                p2.append('1');
            }
        }
        int l=0;
        int dif1=0;
        int dif2=0;
        int ans=Integer.MAX_VALUE;
        String str=s+s;
        for(int r=0;r<2*s.length();r++){
            if(str.charAt(r)!=p1.charAt(r)) dif1++;
            if(str.charAt(r)!=p2.charAt(r)) dif2++;

            if(r-l+1>s.length()){
                if(str.charAt(l)!=p1.charAt(l)) dif1--;
                if(str.charAt(l)!=p2.charAt(l)) dif2--;
                l++;
            }
            if(r-l+1==s.length()){
                ans=Math.min(ans,Math.min(dif1,dif2));
            }
        }
        return ans;        
    }
    
}