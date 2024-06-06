class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        int res=0;
        for(int key:map.keySet()){
            if(map.get(key)>nums.length/2){
                res=key;
            }
        }
        return res;
        
    }
}