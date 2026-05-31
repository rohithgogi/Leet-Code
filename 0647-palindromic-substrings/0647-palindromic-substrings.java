class Solution {
    public int countSubstrings(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(s,i,j)){
                    ans++;
                }
            }
        }
        return ans;
    }
    public boolean isPalindrome(String s,int i,int j){
        int start=i;
        int end=j;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}