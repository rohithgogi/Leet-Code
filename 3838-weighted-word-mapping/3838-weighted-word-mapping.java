class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb=new StringBuilder();
        for(String s:words){
            int wt=0;
            for(char c:s.toCharArray()){
                wt+=weights[c-'a'];
            }
            wt=wt%26;
            sb.append((char)(25-wt+'a'));
        }
        return sb.toString();
    }
}