class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int low=1;
        int high=0;
        for(int i:piles){
            high=Math.max(i,high);
        }
      
        while(low<=high){
            int mid=low+(high-low)/2;
            long totalhrs=0;
            for(int i:piles){
                totalhrs+=(i+mid-1)/mid; // to get the ceil(example 5/2)
                if(totalhrs>h) break;
            }
            if(totalhrs<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}