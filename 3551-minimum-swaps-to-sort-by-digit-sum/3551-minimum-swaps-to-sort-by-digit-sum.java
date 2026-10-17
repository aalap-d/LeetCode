import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i];
        }

        Arrays.sort(a, (x, y) -> {
            int sx = d(x);
            int sy = d(y);
            if (sx != sy) {
                return Integer.compare(sx, sy);
            }
            return Integer.compare(x, y);
        });

        Map<Integer, Integer> p = new HashMap<>();
        for (int i = 0; i < n; i++) {
            p.put(a[i], i);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] || p.get(nums[i]) == i) {
                continue;
            }

            int len = 0;
            int cur = i;
            while (!vis[cur]) {
                vis[cur] = true;
                cur = p.get(nums[cur]);
                len++;
            }

            if (len > 0) {
                ans += len - 1;
            }
        }

        return ans;
    }

    private int d(int x) {
        int s = 0;
        while (x > 0) {
            s += x % 10;
            x /= 10;
        }
        return s;
    }
}