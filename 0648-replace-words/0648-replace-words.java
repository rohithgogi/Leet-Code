class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words=sentence.split(" ");
        for(int i=0;i<words.length;i++){
            words[i]=check(words[i],dictionary);
        }
        return String.join(" ",words);
    }
    String check(String word,List<String> dictionary){
        String ans=word;
        for(String dict:dictionary){
            int i=0;
            while(i<dict.length() && i<ans.length() && word.charAt(i)==dict.charAt(i)){
                i++;
            }
            if(i==dict.length()){
                if(ans.length()>dict.length()) ans=dict;
            }
            
        }
        return ans;
    }
}