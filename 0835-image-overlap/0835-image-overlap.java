import java.util.*;

class Solution {
    public int largestOverlap(int[][] a, int[][] b) {
        int n = a.length;
        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    p1.add(i * 100 + j);
                }
                if (b[i][j] == 1) {
                    p2.add(i * 100 + j);
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int x : p1) {
            for (int y : p2) {
                int d = x - y;
                int c = map.getOrDefault(d, 0) + 1;
                map.put(d, c);
                if (c > ans) {
                    ans = c;
                }
            }
        }

        return ans;
    }
}