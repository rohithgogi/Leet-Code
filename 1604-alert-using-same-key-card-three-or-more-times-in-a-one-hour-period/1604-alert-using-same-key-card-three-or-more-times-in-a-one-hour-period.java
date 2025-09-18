class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String,List<Integer>> map=new HashMap<>();
        
        for(int i=0;i<keyName.length;i++){
            String[] time=keyTime[i].split(":");
            int hr=Integer.parseInt(time[0])*60;
            int min=Integer.parseInt(time[1]);
            int total=hr+min;
            if(!map.containsKey(keyName[i])){
                map.put(keyName[i], new ArrayList<>());
            }
            map.get(keyName[i]).add(total);
        }
        List<String> res=new ArrayList<>();
        for(String name:map.keySet()){
            List<Integer> times=map.get(name);
            Collections.sort(times);
            for(int i=0;i+2<times.size();i++){
                if((times.get(i+2)-times.get(i))<=60){
                    res.add(name);
                    break;
                }
            }

        }
        return res;
    }
}