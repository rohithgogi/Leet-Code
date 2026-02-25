class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        backtrack(0,board,ans,n);
        return ans;
    }
    public void backtrack(int col,char[][] board, List<List<String>> ans,int n){
        if(col==n){
            List<String> temp=new ArrayList<>();
            for(char[] c:board) temp.add(new String(c));
            ans.add(temp);
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col]='Q';
                backtrack(col+1,board,ans,n);
                board[row][col]='.';
            }
        }
    }
    public boolean isSafe(int row,int col,char[][] board,int n){
        int duprow=row;
        int dupcol=col;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }
        row=duprow;
        col=dupcol;
        while(col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }
        row=duprow;
        col=dupcol;
        while(row<n && col>=0){
            if(board[row][col]=='Q') return false;
            row++;
            col--;
        }
        return true;
    }
}