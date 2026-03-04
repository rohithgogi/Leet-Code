class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map=new HashMap<>();
            for(int i:nums){
                if(map.containsKey(i)){
                    map.put(i,map.get(i)+1);
                }else{
                    map.put(i,1);
                }
                
            }
        
        List<Integer>[] bucket =new ArrayList[nums.length+1];
        for(int i:map.keySet()){
            int freq=map.get(i);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(i);

        }
        int j=0;
        int[] res=new int[k];
        for(int i=nums.length;i>=1;i--){
            if(bucket[i]!=null){
                for(int num:bucket[i]){
                    res[j]=num;
                    j++;
                    if(j==k){
                        return res;
                    }
                }
            }
        }
        return new int[]{};
    }
}