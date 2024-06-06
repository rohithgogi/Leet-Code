class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
            
        }
        List<Integer> list=new ArrayList<>(map.values());
        Set<Integer> set=new HashSet<>(list);
        if(list.size()>set.size()){
            return false;
        }else{
           return true; 
        }
     
    }
}