class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] freq=new int[26];
        int[] windowFreq=new int[26];
 
        for(char c:s1.toCharArray()){
            freq[c-'a']++;
        }
        int k=s1.length();
       
        for(int r=0;r<s2.length();r++){
            windowFreq[s2.charAt(r)-'a']++;
            if(r>=k){
                windowFreq[s2.charAt(r-k)-'a']--;
            }

            if(Arrays.equals(freq,windowFreq)) return true;
        }
        return false;
    }
}