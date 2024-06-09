class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0) return false;
        List<Character> ch=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                ch.add(Character.toLowerCase(s.charAt(i)));
            }
        }
        int start=0;
        int end=ch.size()-1;
        if(ch.size()==0) return true;
        while(start<=end){
            if(ch.get(start)!=ch.get(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}