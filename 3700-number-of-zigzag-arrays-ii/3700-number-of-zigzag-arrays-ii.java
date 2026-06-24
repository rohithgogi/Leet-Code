class Solution {

    static final long MOD = 1_000_000_007L;

    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {

                if (a[i][k] == 0) continue;

                for (int j = 0; j < n; j++) {

                    if (b[k][j] == 0) continue;

                    res[i][j] =
                        (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return res;
    }

    private long[][] power(long[][] base, long exp) {

        int n = base.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {

            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }

            base = multiply(base, base);

            exp >>= 1;
        }

        return res;
    }

    private long[] multiplyMatVec(long[][] mat, long[] vec) {

        int n = mat.length;

        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {

            long sum = 0;

            for (int j = 0; j < n; j++) {

                sum = (sum + mat[i][j] * vec[j]) % MOD;
            }

            ans[i] = sum;
        }

        return ans;
    }

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;
        int size = 2 * m;

        long[][] T = new long[size][size];

        for (int i = 0; i < m; i++) {

            // up[i] -> down[j]
            for (int j = 0; j < i; j++) {
                T[m + j][i] = 1;
            }

            // down[i] -> up[j]
            for (int j = i + 1; j < m; j++) {
                T[j][m + i] = 1;
            }
        }

        long[] start = new long[size];

        for (int i = 0; i < size; i++) {
            start[i] = 1;
        }

        long[][] P = power(T, n - 1);

        long[] finalState = multiplyMatVec(P, start);

        long ans = 0;

        for (long x : finalState) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }
}