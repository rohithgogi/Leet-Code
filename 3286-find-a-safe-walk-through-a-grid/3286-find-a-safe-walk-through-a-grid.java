class Solution {

    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int n = grid.size();
        int m = grid.get(0).size();

        int[][] dist = new int[n][m];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> dq = new ArrayDeque<>();

        dist[0][0] = grid.get(0).get(0);
        dq.offerFirst(new int[]{0,0});

        while (!dq.isEmpty()) {

            int[] curr = dq.pollFirst();
            int r = curr[0];
            int c = curr[1];

            for (int[] d : dirs) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;

                int cost = grid.get(nr).get(nc);

                if (dist[r][c] + cost < dist[nr][nc]) {

                    dist[nr][nc] = dist[r][c] + cost;

                    if (cost == 0)
                        dq.offerFirst(new int[]{nr,nc});
                    else
                        dq.offerLast(new int[]{nr,nc});
                }
            }
        }

        return dist[n-1][m-1] < health;
    }
}