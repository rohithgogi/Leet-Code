class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int j=0;j<m;j++){
            if(board[0][j]=='O'){
                dfs(0,j,vis,board);
            }
        }
        for(int i=1;i<n;i++){
            if(board[i][m-1]=='O'){
                dfs(i,m-1,vis,board);
            }
        }
        for(int j=m-2;j>=0;j--){
            if(board[n-1][j]=='O'){
                dfs(n-1,j,vis,board);
            }
        }
        for(int i=n-2;i>=1;i--){
            if(board[i][0]=='O'){
                dfs(i,0,vis,board);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(int r,int c,boolean[][] vis,char[][] board){
        vis[r][c]=true;
        int[] rdir={-1,0,1,0};
        int[] cdir={0,-1,0,1};
        for(int i=0;i<4;i++){
            int nr=r+rdir[i];
            int nc=c+cdir[i];
            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && board[nr][nc]=='O' && vis[nr][nc]==false){

                dfs(nr,nc,vis,board);
            }
        }
    }
}