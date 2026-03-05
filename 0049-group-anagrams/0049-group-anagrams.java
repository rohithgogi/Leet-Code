class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<String>> map=new HashMap();
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            char[] c=strs[i].toCharArray();
            Arrays.sort(c);
            String temp=new String(c);
            if(map.containsKey(temp)){
                ArrayList<String> list=map.get(temp);
                list.add(strs[i]);
                map.put(temp,list);
            }else{
                map.put(temp,new ArrayList<>());
                map.get(temp).add(strs[i]);
            }

        }
        for(List<String> s:map.values()){
            ans.add(s);
        }
        return ans;

    }
}