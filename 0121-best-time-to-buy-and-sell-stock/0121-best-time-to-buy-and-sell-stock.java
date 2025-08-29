class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int profit=0;
        for(int p:prices){
            if(p<minPrice){
                minPrice=p;
            }else{
                profit=Math.max(profit,p-minPrice);
            }
        }
        return profit;
    }
}