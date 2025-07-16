class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int cur=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String str=s.substring(i,j);
                if(isUnique(str)){
                    cur=str.length();
                    if(cur>=max){
                        max=cur;
                    }
                }
            }
        }
        return max;
    }

    public boolean isUnique(String s){
        Set<Character> seen=new HashSet();
        for(char c:s.toCharArray()){
            if(!seen.add(c)){
                return false;
            }
        }
        return true;
    }
}