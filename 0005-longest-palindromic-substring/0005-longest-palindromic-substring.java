class Solution {
    public String longestPalindrome(String s) {
        String longest="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(i,j,s) && (j-i+1)>longest.length()){
                    longest=s.substring(i,j+1);
                }
            }
        }
        return longest;
    }
    public boolean isPalindrome(int s,int e,String str){
        while(s<=e){
            if(str.charAt(e)!=str.charAt(s)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}