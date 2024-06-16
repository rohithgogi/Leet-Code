class Solution {
    public int partitionString(String s) {
        Map<Character,Integer> hm=new HashMap<>();
        int ans=0;
        for(char c:s.toCharArray()){
            if(hm.containsKey(c)){
                ans++;
                hm.clear();
            }
            hm.put(c,1);
        }
        return ans+1;
    }
}