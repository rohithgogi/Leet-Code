class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i:nums){
            map.put(i,0);
        }
        int max=1;
        int count=1;
        List<Integer> list=new ArrayList<>();
        for(int i:map.keySet()){
            list.add(i);
        }
        for(int i=1;i<list.size();i++){
            if(list.get(i)==list.get(i-1)+1){
                count++;
            }else{
                
                count=1;
            }
            max=Math.max(count,max);
        }
        return max;
    }
}