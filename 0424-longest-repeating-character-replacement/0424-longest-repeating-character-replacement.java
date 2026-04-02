class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int l=0;
        int r=0;
        int size=0;
        int maxFreq=0;
        for(r=0;r<s.length();r++){
            freq[s.charAt(r)-'A']++;

            maxFreq=Math.max(maxFreq,freq[s.charAt(r)-'A']);
            if((r-l+1)-maxFreq>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            size=Math.max(r-l+1,size);
        }
        return size;
    }
    
}