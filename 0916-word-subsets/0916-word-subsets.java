class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq= new int[26];
        for(String w: words2){
            int[] currFreq=new int[26];
            for(char c:w.toCharArray()){
                currFreq[c-'a']++;
            }
            for(int i=0;i<26;i++){
                maxFreq[i]=Math.max(maxFreq[i],currFreq[i]);
            }
        }
        List<String> result=new ArrayList();
        for(String word: words1){
            int[] frq=new int[26];
            for(char c: word.toCharArray()) frq[c-'a']++;
            if(isTrue(frq,maxFreq)){
                result.add(word);
            }
        }
        return result;
    }
    public boolean isTrue(int[] wordFreq,int[] maxFreq){
        for(int i=0;i<26;i++){
            if(wordFreq[i]<maxFreq[i]){
                return false;
            }
        }
        return true;
    }
}