import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] f = new int[26];
        int[] l = new int[26];
        Arrays.fill(f, -1);
        Arrays.fill(l, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (f[c] == -1) f[c] = i;
            l[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (f[i] == -1) continue;

            int left = f[i];
            int right = l[i];
            boolean ok = true;

            for (int j = left; j <= right; j++) {
                int c = s.charAt(j) - 'a';
                if (f[c] < left) {
                    ok = false;
                    break;
                }
                right = Math.max(right, l[c]);
            }

            if (ok) {
                intervals.add(new int[]{left, right});
            }
        }

        intervals.sort(Comparator.comparingInt(a -> a[1]));

        List<String> res = new ArrayList<>();
        int last = -1;

        for (int[] inv : intervals) {
            if (inv[0] > last) {
                res.add(s.substring(inv[0], inv[1] + 1));
                last = inv[1];
            }
        }

        return res;
    }
}