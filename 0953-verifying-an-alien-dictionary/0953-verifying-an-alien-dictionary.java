class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] lexi=new int[26];
        for(int i=0;i<26;i++){
            lexi[order.charAt(i)-'a']=i;
        }
        for(int i=0;i<words.length-1;i++){
            if(!isSorted(words[i],words[i+1],lexi)){
                return false;
            }
        }
        return true;
    }
    public boolean isSorted(String w1,String w2,int[] lexi){
        for(int i=0;i<Math.min(w1.length(),w2.length());i++){
            if(lexi[w1.charAt(i)-'a']>lexi[w2.charAt(i)-'a']){
                return false;
            }else if(lexi[w1.charAt(i)-'a']<lexi[w2.charAt(i)-'a']) return true;
        }
        if(w1.length()>w2.length()) return false;
        return true;
    }
}