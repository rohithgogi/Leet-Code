import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) return steps;

                for (String next : neighbors(cur)) {
                    if (!visited.contains(next) && !dead.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private List<String> neighbors(String node) {
        List<String> res = new ArrayList<>();
        char[] arr = node.toCharArray();

        for (int i = 0; i < 4; i++) {
            char c = arr[i];
            // rotate forward
            arr[i] = c == '9' ? '0' : (char)(c + 1);
            res.add(new String(arr));
            // rotate backward
            arr[i] = c == '0' ? '9' : (char)(c - 1);
            res.add(new String(arr));
            // restore
            arr[i] = c;
        }

        return res;
    }
}
