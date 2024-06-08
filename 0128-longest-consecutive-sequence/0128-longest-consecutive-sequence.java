class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s=new HashSet<>();
        

        for(int num:nums){
            s.add(num);
        }
        if(s.size()==0) return 0;
        int longest=1;
        for(int i:s){
            if(!s.contains(i-1)){
                int count=1;
                while(s.contains(i+1)){
                    count=count+1;
                    i+=1;
                    longest=Math.max(longest,count);
                }
            }
        }
        return longest;
    }
}