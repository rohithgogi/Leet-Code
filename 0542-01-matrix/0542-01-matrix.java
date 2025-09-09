class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dis=new int[mat.length][mat[0].length];
        boolean[][] vis=new int[mat.length][mat[0].length];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0});
                    vis[i][j]=true;
                }else{
                    vis[i][j]=false;
                }
            }
        }
        int[] rdir={0,-1,0,1};
        int[] cdir={1,0,-1,0};

        while(!q.isEmpty()){
            int[] arr=q.poll();
            int row=arr[0];
            int col=arr[1];
            int d=arr[2];
            dis[row][col]=d;
            for(int i=0;i<4;i++){
                int r=row+rdir[i];
                int c=col+cdir[i];

                if(r>=0 && r<mat.length && c>=0 && c<mat[0].length && !vis[r][c]){
                    vis[r][c]=true;
                    q.add(new int[]{r,c,d+1});
                }
            }
        }
        return dis;

    }
}