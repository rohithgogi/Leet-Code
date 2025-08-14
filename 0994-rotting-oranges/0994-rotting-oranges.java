
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        Queue<List<Integer>> q=new LinkedList<>();
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(Arrays.asList(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
            }
        }
        int tm=0;
        int[] rdir={-1,0,1,0};
        int[] cdir={0,-1,0,1};
        while(!q.isEmpty()){
            int r=q.peek().get(0);
            int c=q.peek().get(1);
            int t=q.peek().get(2);
            tm=Math.max(tm,t);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow=r+rdir[i];
                int ncol=c+cdir[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    q.offer(Arrays.asList(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=2 && grid[i][j]==1){
                    return -1;
                }
            }
        }
        return tm;


    }
   
}