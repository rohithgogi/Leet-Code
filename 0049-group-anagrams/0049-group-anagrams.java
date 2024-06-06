class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hm=new HashMap<>();
        for(String str:strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String sortedstr=new String(chars);
            if(!hm.containsKey(sortedstr)){
                hm.put(sortedstr,new ArrayList<>());
            }
            hm.get(sortedstr).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}