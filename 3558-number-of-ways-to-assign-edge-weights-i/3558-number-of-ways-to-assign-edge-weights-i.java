class Solution {
    private static final long MOD = 1_000_000_007L;
    int maxDepth = 0;

    public int assignEdgeWeights(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        dfs(1, -1, 0, adj);

        if (maxDepth == 0) {
            return 0;
        }

        return (int) modPow(2, maxDepth - 1);
    }

    private void dfs(int node, int parent, int depth,
                     Map<Integer, List<Integer>> adj) {

        maxDepth = Math.max(maxDepth, depth);

        for (int nei : adj.getOrDefault(node, Collections.emptyList())) {
            if (nei != parent) {
                dfs(nei, node, depth + 1, adj);
            }
        }
    }

    private long modPow(long base, long exp) {
        long res = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }
}