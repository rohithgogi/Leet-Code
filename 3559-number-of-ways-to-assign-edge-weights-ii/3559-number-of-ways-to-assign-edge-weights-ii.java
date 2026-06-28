class Solution {

    static final int MOD = 1_000_000_007;
    static final int LOG = 17;

    List<Integer>[] graph;
    int[][] parent;
    int[] depth;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        int n = edges.length + 1;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        parent = new int[LOG][n + 1];
        depth = new int[n + 1];

        Arrays.fill(parent[0], -1);

        dfs(1, -1);

        for (int k = 1; k < LOG; k++) {
            for (int v = 1; v <= n; v++) {
                if (parent[k - 1][v] != -1)
                    parent[k][v] = parent[k - 1][parent[k - 1][v]];
                else
                    parent[k][v] = -1;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            if (u == v) {
                ans[i] = 0;
                continue;
            }

            int lca = lca(u, v);

            int dist = depth[u] + depth[v] - 2 * depth[lca];

            ans[i] = modPow(2, dist - 1);
        }

        return ans;
    }

    void dfs(int u, int p) {

        parent[0][u] = p;

        for (int v : graph[u]) {

            if (v == p)
                continue;

            depth[v] = depth[u] + 1;

            dfs(v, u);
        }
    }

    int lca(int u, int v) {

        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            if (parent[k][u] != -1 &&
                    depth[parent[k][u]] >= depth[v]) {
                u = parent[k][u];
            }
        }

        if (u == v)
            return u;

        for (int k = LOG - 1; k >= 0; k--) {

            if (parent[k][u] != -1 &&
                    parent[k][u] != parent[k][v]) {

                u = parent[k][u];
                v = parent[k][v];
            }
        }

        return parent[0][u];
    }

    int modPow(long a, int b) {

        long ans = 1;

        while (b > 0) {

            if ((b & 1) == 1)
                ans = (ans * a) % MOD;

            a = (a * a) % MOD;

            b >>= 1;
        }

        return (int) ans;
    }
}