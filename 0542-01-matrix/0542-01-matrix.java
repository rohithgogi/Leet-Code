
class Node{
    int first;
    int second;
    int third;
    Node(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    private int[] rdir={0,1,0,-1};
    private int[] cdir={1,0,-1,0};
    
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] vis=new int[n][m];
        int[][] dist=new int[n][m];

        Queue<Node> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }else{
                    vis[i][j]=0;
                }
            }
        }

        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int steps=q.peek().third;
            q.remove();
            dist[row][col]=steps;
            for(int i=0;i<4;i++){
                int nr=row+rdir[i];
                int nc=col+cdir[i];

                if(nr>=0 && nc>=0 &&nr<n && nc<m &&vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    q.add(new Node(nr,nc,steps+1));
                }
            }
        }


        return dist;
    }
    

}