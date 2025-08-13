class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ini=image[sr][sc];
        int[][] ans=image;
        int[] rdir={-1,0,1,0};
        int[] cdir={0,1,0,-1};
        dfs(sr,sc,image,ans,color,ini,rdir,cdir);
        return ans;

    }
    public static void dfs( int r,int c,int[][] image,int[][] ans,int color,int ini,int[] rdir,int[] cdir){
        ans[r][c]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nr=r+rdir[i];
            int nc=c+cdir[i];
            if(nr>=0 && nc>=0 && nr<n && nc<m && image[nr][nc]==ini && ans[nr][nc]!=color){
                dfs(nr,nc,image,ans,color,ini,rdir,cdir);           
            }
        }       
    }
}