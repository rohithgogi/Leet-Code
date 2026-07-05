class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (board.get(i).charAt(j) == 'X')
                    continue;

                if (i == n - 1 && j == n - 1)
                    continue;

                int maxScore = -1;

                if (i + 1 < n && ways[i + 1][j] > 0)
                    maxScore = Math.max(maxScore, score[i + 1][j]);

                if (j + 1 < n && ways[i][j + 1] > 0)
                    maxScore = Math.max(maxScore, score[i][j + 1]);

                if (i + 1 < n && j + 1 < n && ways[i + 1][j + 1] > 0)
                    maxScore = Math.max(maxScore, score[i + 1][j + 1]);

                if (maxScore == -1)
                    continue;

                if (i + 1 < n && ways[i + 1][j] > 0 && score[i + 1][j] == maxScore)
                    ways[i][j] = (ways[i][j] + ways[i + 1][j]) % MOD;

                if (j + 1 < n && ways[i][j + 1] > 0 && score[i][j + 1] == maxScore)
                    ways[i][j] = (ways[i][j] + ways[i][j + 1]) % MOD;

                if (i + 1 < n && j + 1 < n && ways[i + 1][j + 1] > 0 && score[i + 1][j + 1] == maxScore)
                    ways[i][j] = (ways[i][j] + ways[i + 1][j + 1]) % MOD;

                score[i][j] = maxScore;

                char ch = board.get(i).charAt(j);
                if (Character.isDigit(ch))
                    score[i][j] += ch - '0';
            }
        }

        if (ways[0][0] == 0)
            return new int[]{0, 0};

        return new int[]{score[0][0], ways[0][0]};
    }
}