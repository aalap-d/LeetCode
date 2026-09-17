import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length, s = 0, inf = 1_000_000_000, ans = inf;
        int[] m = new int[n];
        Map<Integer, Integer> p = new HashMap<>();
        p.put(0, -1);

        for (int i = 0; i < n; i++) {
            s += arr[i];
            p.put(s, i);
            m[i] = (i > 0) ? m[i - 1] : inf;

            int req = s - target;
            if (p.containsKey(req)) {
                int j = p.get(req);
                int len = i - j;
                if (j >= 0 && m[j] != inf) {
                    ans = Math.min(ans, len + m[j]);
                }
                m[i] = Math.min(m[i], len);
            }
        }

        return ans >= inf ? -1 : ans;
    }
}