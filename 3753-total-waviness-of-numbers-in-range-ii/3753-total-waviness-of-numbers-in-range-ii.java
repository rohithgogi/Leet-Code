class Solution {

    static class Pair {
        long count;
        long waviness;

        Pair(long count, long waviness) {
            this.count = count;
            this.waviness = waviness;
        }
    }

    private String digits;
    private Pair[][][][][] dp;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x < 0) return 0;

        digits = String.valueOf(x);

        dp = new Pair[digits.length()][11][11][2][2];

        return dfs(0, 10, 10, 0, 1).waviness;
    }

    private Pair dfs(int pos,
                     int prev2,
                     int prev1,
                     int started,
                     int tight) {

        if (pos == digits.length()) {
            return new Pair(1, 0);
        }

        if (tight == 0 &&
            dp[pos][prev2][prev1][started][0] != null) {
            return dp[pos][prev2][prev1][started][0];
        }

        int limit = tight == 1
                ? digits.charAt(pos) - '0'
                : 9;

        long totalCount = 0;
        long totalWaviness = 0;

        for (int d = 0; d <= limit; d++) {

            int nextTight =
                    (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {

                Pair child = dfs(
                        pos + 1,
                        10,
                        10,
                        0,
                        nextTight
                );

                totalCount += child.count;
                totalWaviness += child.waviness;

                continue;
            }

            if (started == 0) {

                Pair child = dfs(
                        pos + 1,
                        10,
                        d,
                        1,
                        nextTight
                );

                totalCount += child.count;
                totalWaviness += child.waviness;

                continue;
            }

            if (prev2 == 10) {

                Pair child = dfs(
                        pos + 1,
                        prev1,
                        d,
                        1,
                        nextTight
                );

                totalCount += child.count;
                totalWaviness += child.waviness;

                continue;
            }

            boolean wave =
                    (prev2 < prev1 && prev1 > d) ||
                    (prev2 > prev1 && prev1 < d);

            Pair child = dfs(
                    pos + 1,
                    prev1,
                    d,
                    1,
                    nextTight
            );

            totalCount += child.count;

            if (wave) {
                totalWaviness += child.waviness + child.count;
            } else {
                totalWaviness += child.waviness;
            }
        }

        Pair ans = new Pair(totalCount, totalWaviness);

        if (tight == 0) {
            dp[pos][prev2][prev1][started][0] = ans;
        }

        return ans;
    }
}