class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude=0;
        int prev=0;
        for(int i:gain){
            prev+=i;
            maxAltitude=Math.max(maxAltitude,prev);
        }
        return maxAltitude;
    }
}