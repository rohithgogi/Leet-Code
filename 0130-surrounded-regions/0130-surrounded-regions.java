class Node{
    int row;
    int col;
    Node(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    private int[] rdir={0,1,0,-1};
    private int[] cdir={1,0,-1,0};
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];
        
        for(int i=0;i<n;i++){
            
            if(board[i][0]=='O'&& vis[i][0]==0){
                vis[i][0]=1;
                dfs(i,0,board,vis);
            }
            
            if(board[i][m-1]=='O' && vis[i][m-1]==0){
                vis[i][m-1]=1;
                dfs(i,m-1,board,vis);
            }
        }
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && vis[0][i]==0){
                vis[0][i]=1;
                dfs(0,i,board,vis);  
            }
            
            if(board[n-1][i]=='O'&& vis[n-1][i]==0){
                vis[n-1][i]=1;
                dfs(n-1,i,board,vis);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=1) board[i][j]='X';
            }
        }
        
    }
    public void dfs(int row,int col,char[][] board,int[][] vis){
        vis[row][col]=1;
        for(int i=0;i<4;i++){
            int nr=row+rdir[i];
            int nc=col+cdir[i];
            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && vis[nr][nc]==0 && board[nr][nc]=='O'){
                dfs(nr,nc,board,vis);

            }
        }

    }
}