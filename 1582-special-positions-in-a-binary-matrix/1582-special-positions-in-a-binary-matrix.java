class Solution {
    public int numSpecial(int[][] mat) {
        int count=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0; j<mat[0].length;j++){
                if(mat[i][j]==1 && special(i,j,mat)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean special(int i,int j,int[][] mat){
        int a=i;
        int b=j;
        while(a<mat.length-1){
            a++;
            if(mat[a][b]==1) return false;
        }
        a=i;
        while(a>0){
            a--;
            if(mat[a][b]==1) return false;
        }
        a=i;
        while(b<mat[0].length-1){
            b++;
            if(mat[a][b]==1) return false;
        }
        b=j;
        while(b>0){
            b--;
            if(mat[a][b]==1) return false;
        }
        return true;
    }
    
}