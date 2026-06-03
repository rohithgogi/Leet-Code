import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans1 = solveOrder(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration
        );

        int ans2 = solveOrder(
                waterStartTime,
                waterDuration,
                landStartTime,
                landDuration
        );

        return Math.min(ans1, ans2);
    }

    private int solveOrder(int[] firstStart, int[] firstDuration,
                           int[] secondStart, int[] secondDuration) {

        int m = secondStart.length;

        int[][] rides = new int[m][2];

        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDuration[i];
        }

        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

        int[] starts = new int[m];
        int[] prefMinDuration = new int[m];
        int[] suffMinFinish = new int[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        prefMinDuration[0] = rides[0][1];
        for (int i = 1; i < m; i++) {
            prefMinDuration[i] =
                    Math.min(prefMinDuration[i - 1], rides[i][1]);
        }

        suffMinFinish[m - 1] =
                rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffMinFinish[i] =
                    Math.min(
                            suffMinFinish[i + 1],
                            rides[i][0] + rides[i][1]
                    );
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {

            int endTime = firstStart[i] + firstDuration[i];

            int idx = upperBound(starts, endTime);

            // Case 1:
            // second ride starts before or exactly at endTime
            if (idx > 0) {
                answer = Math.min(
                        answer,
                        endTime + prefMinDuration[idx - 1]
                );
            }

            // Case 2:
            // second ride starts after endTime
            if (idx < m) {
                answer = Math.min(
                        answer,
                        suffMinFinish[idx]
                );
            }
        }

        return answer;
    }

    private int upperBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}