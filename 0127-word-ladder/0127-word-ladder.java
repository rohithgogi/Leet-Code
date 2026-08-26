class Pair{
    String word;
    int step;
    Pair(String word,int step){
        this.word=word;
        this.step=step;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set=new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }


        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            String word=q.peek().word;
            int steps=q.peek().step;
            q.remove();
            if(word.equals(endWord)) return steps;

            for(int i=0;i<word.length();i++){
                for(char c='a';c<='z';c++){
                    char[] replacedArray=word.toCharArray();
                    replacedArray[i]=c;
                    String replaced=new String(replacedArray);
                    if(set.contains(replaced)){
                        set.remove(replaced);
                        q.add(new Pair(replaced,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}