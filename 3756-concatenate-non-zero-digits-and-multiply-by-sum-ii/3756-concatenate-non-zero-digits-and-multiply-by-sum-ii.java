class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] cnt = new int[n + 1];
        List<Integer> digits = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cnt[i + 1] = cnt[i];
            int d = s.charAt(i) - '0';
            if (d != 0) {
                digits.add(d);
                cnt[i + 1]++;
            }
        }

        int m = digits.size();

        long[] prefNum = new long[m + 1];
        long[] pow10 = new long[m + 1];
        int[] prefSum = new int[m + 1];

        pow10[0] = 1;

        for (int i = 0; i < m; i++) {
            pow10[i + 1] = (pow10[i] * 10) % MOD;
            prefNum[i + 1] = (prefNum[i] * 10 + digits.get(i)) % MOD;
            prefSum[i + 1] = prefSum[i] + digits.get(i);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int L = cnt[l];
            int R = cnt[r + 1] - 1;

            if (L > R) {
                ans[i] = 0;
                continue;
            }

            int sum = prefSum[R + 1] - prefSum[L];
            int len = R - L + 1;

            long num = (prefNum[R + 1] - (prefNum[L] * pow10[len]) % MOD + MOD) % MOD;

            ans[i] = (int) ((num * sum) % MOD);
        }

        return ans;
    }
}