class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()) return false;
        char[] sa=s.toCharArray();
        char[] ta=t.toCharArray();
        int i=0;
        int j=0;
        while(i<sa.length && j<ta.length){
            if(sa[i]==ta[j]){
                i++;
            }
            j++;
        }
        return i==sa.length;
    }
}