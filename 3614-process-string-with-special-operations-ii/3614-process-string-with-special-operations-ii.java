class Solution {
    public char processStr(String s, long k) {
        StringBuilder res=new StringBuilder();
        long size = 0;
       
        for(char c:s.toCharArray()){
            if(Character.isLetter(c)){
                size++;
            }else if(c=='*'){
                if(size>0) size--;
            }else if(c=='#'){
                size=size*2;
            }
            size = Math.min(size, (long)1e18);
        }
        if(k>=size) return '.';
        for(int i=s.length()-1;i>=0;i--){
            char c=s.charAt(i);
            if(Character.isLetter(c)){
                size--;
                if(k==size) return c;
            }
            else if(c=='*'){
                size++;
            }else if(c=='#'){
                size=size/2;
                if(k>=size){
                    k=k-size;
                }
            }else if(c=='%'){
                k=size-1-k;
            }
            
        }
        return '.';
    }
}