class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
       
        int[] vis=new int[n];
        
        for(int i=1;i<n;i++){
            
            if(Math.abs(nums[i]-nums[i-1])<=maxDiff){
                vis[i]=vis[i-1];
            }else{
                vis[i]=vis[i-1]+1;
            }
        }
        boolean[] ans=new boolean[queries.length];
        int j=0;
        for(int[] q:queries){
            if(vis[q[0]]==vis[q[1]]) ans[j]=true;
            else ans[j]=false;
            j++;
        }
        return ans;
    }

}