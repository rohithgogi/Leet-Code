class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String>map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> list=new ArrayList<>();
        backtrack(digits,0,new StringBuilder(),list,map);
        return list;
        
    }
    public void backtrack(String digits,int idx,StringBuilder currString,List<String> list,Map<Character,String> map){
        if(currString.length()==digits.length()){
            list.add(new String(currString.toString()));
            return;
        }
        String letters=map.get(digits.charAt(idx));
        for(char ch:letters.toCharArray()){
            backtrack(digits,idx+1,currString.append(ch),list,map);
            currString.deleteCharAt(currString.length()-1);
        }

    }
}