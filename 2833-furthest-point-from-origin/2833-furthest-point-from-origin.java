class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left=0;
        int right=0;
        int count=0;
        for(char c:moves.toCharArray()){
            if(c=='L'){
                left++;
            }else if(c=='R'){
                right++;
            }else{
                count++;
            }
        }
        
        return Math.max(Math.abs(right-left-count),Math.abs(right+count-left));
    }
}