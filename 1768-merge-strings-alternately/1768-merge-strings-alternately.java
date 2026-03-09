class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans="";
        int x=0;
        int y=0;
        while(x<word1.length() && y<word2.length()){
            ans+=word1.charAt(x);
            ans+=word2.charAt(y);
            x++;
            y++;
        }
        if(x<word1.length()){
            ans+=word1.substring(x,word1.length());
        }
        if(y<word2.length()){
            ans+=word2.substring(y,word2.length());
        }
        return ans;
    }
}