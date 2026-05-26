class Solution {
    public int numberOfSpecialChars(String word) {
        
        Set<Character> set=new HashSet<>();
        Set<Character> ans=new HashSet<>();
        
        if(word.length()<2) return ans.size();
        
        for(char c: word.toCharArray()){
            if(set.isEmpty()){
                set.add(c);
                continue;
            }
            if(Character.isUpperCase(c)){
                if(set.contains(Character.toLowerCase(c))){
                    ans.add(Character.toUpperCase(c));
                    set.remove(Character.toLowerCase(c));
                }else{
                    set.add(c);
                } 
                
            }else{
                if(set.contains(Character.toUpperCase(c))){
                    ans.add(Character.toUpperCase(c));
                    set.remove(Character.toUpperCase(c));
                }else{
                    set.add(c);
                } 

            }
            
        }
        return ans.size();
    }
}