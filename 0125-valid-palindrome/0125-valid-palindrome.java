class Solution {
    public boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r){
            char start;
            char end;
            while(l<r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            start=Character.toLowerCase(s.charAt(l));

            while(l<r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            end=Character.toLowerCase(s.charAt(r));
            if(start!=end) return false;
            l++;
            r--;

        }
        return true;
    }
}