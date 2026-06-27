class Solution {
    public int maximumLength(int[] nums) {
        Map<Long,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put((long)i,map.getOrDefault((long) i,0)+1);
        }
        int ans=1;
        
        for(long start:map.keySet()){
            if(start==1L){
                int count=map.get(1L);
                ans=Math.max(ans,(count%2==0?count-1:count));
                continue;
            }
            long x=start;
            int len=0;

            while(true){
                if(!map.containsKey(x)){
                    len--;
                    break;
                }
                if(map.get(x)==1){
                    len++;
                    break;
                }

                len+=2;
                if(x>1000000000L/x){
                    len--;
                    break;
                }
                x=x*x;
            }
            ans=Math.max(ans,len);
        }
        return ans;
    }
}