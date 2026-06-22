class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:text.toCharArray()){
            if(c=='b'||c=='a' ||c=='l' ||c=='o' ||c=='n'){
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        int count=0;
        boolean flag=true;
        while(flag){
            for(char c: "balloon".toCharArray()){
                if(!map.containsKey(c) || map.get(c)==0){
                    flag=false;
                    break;
                }
                map.put(c,map.get(c)-1);
            }
            if(flag) count++;
        }
        return count;
    }
}