class Solution {
    public boolean isPalindrome(String s) {
        String str="";
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                str+=Character.toLowerCase(s.charAt(i));
            }
        }
        int st=0;
        int e=str.length()-1;
        while(st<=e){
            if(str.charAt(st)!=str.charAt(e)){
                return false;
            }
            st++;
            e--;
        }
        return true;
    }
}