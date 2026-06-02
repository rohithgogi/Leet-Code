class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans=Integer.MAX_VALUE;
        
        for(int i=0;i<landStartTime.length;i++){
            for(int j=0;j<waterStartTime.length;j++){
                int landend=landStartTime[i]+landDuration[i];
                int finish1=Math.max(landend,waterStartTime[j])+waterDuration[j];

                int waterend=waterStartTime[j]+waterDuration[j];
                int finish2=Math.max(waterend,landStartTime[i])+landDuration[i];

                ans=Math.min(Math.min(finish1,finish2),ans);
            }
        }
        return ans;
    }
}