import java.util.*;

class Solution {
    public int maximumLength(int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : a) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        int r = 1;
        if (m.containsKey(1)) {
            int c = m.get(1);
            r = Math.max(r, c % 2 == 0 ? c - 1 : c);
        }
        for (int k : m.keySet()) {
            if (k == 1) continue;
            int l = 0;
            long v = k;
            while (true) {
                if (v > Integer.MAX_VALUE || !m.containsKey((int) v)) {
                    l -= 1;
                    r = Math.max(r, l);
                    break;
                }
                int c = m.get((int) v);
                if (c >= 2) {
                    l += 2;
                    v = v * v;
                } else {
                    l += 1;
                    r = Math.max(r, l);
                    break;
                }
            }
        }
        return r;
    }
}