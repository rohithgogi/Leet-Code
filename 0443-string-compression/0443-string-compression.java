class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        StringBuilder sb=new StringBuilder();

        int freq=1;
        for(int i=0;i<n;i++){
            char c=chars[i];
            while(i<n-1 && chars[i]==chars[i+1]){
                freq++;
                i++;
            }
            sb.append(c);
            if(freq>1){
                sb.append(freq);
            }
            freq=1;
            
        }
        String comstr=sb.toString();
        char[] comchar=comstr.toCharArray();
        for(int i=0;i<comchar.length;i++){
            chars[i]=comchar[i];
        }
        return comchar.length;
    }
}