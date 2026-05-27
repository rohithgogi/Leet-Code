class Solution {
    public int numberOfSpecialChars(String word) {

        Set<Character> set = new HashSet<>();
        Set<Character> ans = new HashSet<>();
        Set<Character> invalid = new HashSet<>();
        Set<Character> upperSeen = new HashSet<>();

        for (char c : word.toCharArray()) {

            if (Character.isUpperCase(c)) {

                char ch = Character.toLowerCase(c);

                upperSeen.add(ch);

                if (set.contains(ch) && !invalid.contains(ch)) {
                    ans.add(ch);
                }

            } else {

                // lowercase after uppercase -> invalid
                if (upperSeen.contains(c)) {
                    ans.remove(c);
                    invalid.add(c);
                }

                if (!invalid.contains(c)) {
                    set.add(c);
                }
            }
        }

        return ans.size();
    }
}