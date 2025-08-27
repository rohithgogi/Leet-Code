class Solution {
    public void setZeroes(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;

        Queue<ArrayList<Integer>> q=new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    q.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        while(!q.isEmpty()){
            List<Integer> cord=q.poll();
            int i=cord.get(0);
            int j=cord.get(1);
            markZero(matrix,i,j);
        }
    }
    public void markZero(int[][] matrix, int r,int c){
        for(int j = 0;j<matrix[0].length;j++) {
            matrix[r][j]=0;
        }
        for(int i=0;i<matrix.length;i++) {
            matrix[i][c]=0;
        }
    }
}