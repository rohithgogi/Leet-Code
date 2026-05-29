class Solution {
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i : nums){
            int temp=i;
            int ans=0;
            while(temp!=0){
                ans=ans+temp%10;
                temp=temp/10;
            }
            min=Math.min(ans,min);
            
        }
        return min;
    }
}