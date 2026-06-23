class Solution {
    private static final long MOD = 1_000_000_007L;
    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        for (int i = 0; i < m; i++) {
            up[i] = 1;
            down[i] = 1;
        }

        for (int len = 2; len <= n; len++) {

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            long prefix = 0;

            for (int i = 0; i < m; i++) {
                newDown[i] = prefix;
                prefix = (prefix + up[i]) % MOD;
            }

            long suffix = 0;

            for (int i = m - 1; i >= 0; i--) {
                newUp[i] = suffix;
                suffix = (suffix + down[i]) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}