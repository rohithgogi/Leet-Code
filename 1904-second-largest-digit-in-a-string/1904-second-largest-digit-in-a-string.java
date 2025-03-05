class Solution {
    public int secondHighest(String s) {
        int max1=-1;
        int max2=-2;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int ch=s.charAt(i)-'0';
                if(ch>max2 && ch>max1){
                    max2=max1;
                    max1=ch;
                }else if(ch<max1 && ch>max2){
                    max2=ch;
                }
            }
        }if(max2==-2){
            return -1;
        }
        return max2;
    }
}