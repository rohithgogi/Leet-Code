 class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean[][] vis=new boolean[n][m];
                    if(dfs(board, word,i,j,vis,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, String word,int s,int e,boolean[][] vis,int w){
        if(w==word.length()-1) return true;
        vis[s][e]=true;
        int[] rdir={0,-1,0,1};
        int[] cdir={1,0,-1,0};
        
        for(int i=0;i<4;i++){
            int nr=s+rdir[i];
            int nc=e+cdir[i];
            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && vis[nr][nc]==false && board[nr][nc]==word.charAt(w+1)){
                if(dfs(board,word,nr,nc,vis,w+1)){
                    return true;
                }
            }
        }
        vis[s][e]=false;
        return false;

    }
}