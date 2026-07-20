class Node{
    int row;
    int col;
    Node(int row,int col){
        this.row=row;
        this.col=col;
    }
}

class Solution {
    private int[] rdir={1,0,-1,0};
    private int[] cdir={0,-1,0,1};
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        Queue<Node> q=new LinkedList<>();

        for(int i=0;i<m;i++){
            if(grid[i][0]==1 && vis[i][0]==0){
                vis[i][0]=1;
                q.add(new Node(i,0));
            }
            if(grid[i][n-1]==1 && vis[i][n-1]==0){
                vis[i][n-1]=1;
                q.add(new Node(i,n-1));
            }
        }
        for(int i=0;i<n;i++){
            if(grid[0][i]==1 && vis[0][i]==0){
                vis[0][i]=1;
                q.add(new Node(0,i));
            }
            if(grid[m-1][i]==1 && vis[m-1][i]==0){
                vis[m-1][i]=1;
                q.add(new Node(m-1,i));
            }
        }

        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            q.remove();
            
            for(int i=0;i<4;i++){
                int nr=row+rdir[i];
                int nc=col+cdir[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    q.add(new Node(nr,nc));
                    
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}