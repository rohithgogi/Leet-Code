class Solution {
    public boolean checkOnesSegment(String s) {
        int i;
        for(i=0;i<s.length();i++){
            if(s.charAt(i)=='0') break;
        }
        for(int j=i;j<s.length();j++){
            if(s.charAt(j)=='1') return false;
        }
        return true;
    }
}