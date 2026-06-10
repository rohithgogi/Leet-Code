class Solution {

    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        Integer[][][][] dp=new Integer[n][n][n][n];
        int ans = cherries(0, 0, 0, 0, grid,dp);

        return Math.max(0, ans);
    }

    public int cherries(int r1, int c1, int r2, int c2, int[][] grid,Integer[][][][] dp) {

        int n = grid.length;

        // both travelers must have taken same number of steps
        if (r1 + c1 != r2 + c2)
            return (int)-1e8;

        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n)
            return (int)-1e8;

       
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return (int)-1e8;

        if (r1 == n - 1 && c1 == n - 1 &&
            r2 == n - 1 && c2 == n - 1) {
            return grid[n - 1][n - 1];
        }
        if(dp[r1][c1][r2][c2]!=null) return dp[r1][c1][r2][c2];

        int curr;

        if (r1 == r2 && c1 == c2)
            curr = grid[r1][c1];
        else
            curr = grid[r1][c1] + grid[r2][c2];

        int dd = cherries(r1 + 1, c1, r2 + 1, c2, grid,dp);
        int dr = cherries(r1 + 1, c1, r2, c2 + 1, grid,dp);
        int rd = cherries(r1, c1 + 1, r2 + 1, c2, grid,dp);
        int rr = cherries(r1, c1 + 1, r2, c2 + 1, grid,dp);

        int best = Math.max(Math.max(dd, dr), Math.max(rd, rr));

        return dp[r1][c1][r2][c2]=curr + best;
    }
}