class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(!stack.isEmpty()){
                char prev=stack.peek();
                if(map.get(prev)==c){
                    stack.pop();
                }else if(c==')' || c==']' || c=='}'){
                    return false;
                }else{
                    stack.push(c);
                }

            }else{
                if(c==')' || c==']' || c=='}'){
                    return false;
                } else{
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}