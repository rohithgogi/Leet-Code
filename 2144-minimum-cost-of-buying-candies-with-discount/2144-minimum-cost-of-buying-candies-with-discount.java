class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n=cost.length;
        int currcost=0;
        for(int i=n-1;i>=0;i=i-3){
            if(i-1<0){
                currcost+=cost[i];
            }else{
                currcost+=cost[i]+cost[i-1];
            }
            
        }
        return currcost;
    }
}