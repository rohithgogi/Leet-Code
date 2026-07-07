class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff=arr[1]-arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=(arr[0]+(i)*diff)) return false;
        }
        return true;
    }
}