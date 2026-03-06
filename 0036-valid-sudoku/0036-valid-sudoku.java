class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> valid=new HashSet<>();
    
        for(int i=0;i<=8;i++){
            for(int j=0;j<=8;j++){
                char num=board[i][j];
                if(num=='.') continue;
                
                if(!valid.add(num + "in row"+i) ||
                !valid.add(num + "in col"+ j) ||
                !valid.add(num + "in box"+i/3+" "+j/3)) return false;
                
            }
        }
        return true;
    }
    
}