class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int ans=0;
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch)==2){
                ans+=2;
                map.remove(ch);
            }
        }
        if(!map.isEmpty()) ans+=1;
        
        return ans;
    }
}