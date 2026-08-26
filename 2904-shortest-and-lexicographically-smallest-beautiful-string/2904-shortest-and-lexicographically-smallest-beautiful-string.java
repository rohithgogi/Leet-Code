class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int left = 0;
        int cnt = 0;

        String ans = "";
        int len = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                cnt++;
            }

            while (cnt == k) {
                while (s.charAt(left) == '0') {
                    left++;
                }

                String temp = s.substring(left, right + 1);

                if (temp.length() < len ||
                    (temp.length() == len && temp.compareTo(ans) < 0)) {
                    ans = temp;
                    len = temp.length();
                }

                // Remove leftmost 1
                cnt--;
                left++;
            }
        }

        return ans;
    }
}