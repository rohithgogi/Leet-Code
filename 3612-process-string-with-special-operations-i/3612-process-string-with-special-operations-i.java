class Solution {
    public String processStr(String s) {
        StringBuilder res=new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetter(c) && Character.isLowerCase(c)){
                res.append(c);
            }else if(c=='*'){
                if(res.length()>0) res.deleteCharAt(res.length()-1);
            }else if(c=='#'){
                res.append(res);
            }else if(c=='%'){
                res=rev(res);
            }
        }
        return res.toString();
    }
    public StringBuilder rev(StringBuilder s){
        StringBuilder res=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            res.append(s.charAt(i));
        }
        return res;        
    }
}