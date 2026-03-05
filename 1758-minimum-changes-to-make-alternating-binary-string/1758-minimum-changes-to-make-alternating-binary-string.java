class Solution {
    public int minOperations(String s) {
        String pat1="";
        String pat2="";
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                pat1+='0';
                pat2+='1';
            }else{
                pat1+='1';
                pat2+='0';
            }
        }
        int minp1=0;
        int minp2=0;
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c!=pat1.charAt(i)){
                minp1++;
            }
            if(c!=pat2.charAt(i)){
                minp2++;
            }
        }
        return Math.min(minp1,minp2);
        
    }
}