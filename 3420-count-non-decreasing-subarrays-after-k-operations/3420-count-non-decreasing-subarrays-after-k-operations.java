import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] a, int k) {
        int n = a.length;
        long ans = 0;
        long ops = 0;
        int r = n - 1;
        Deque<long[]> q = new ArrayDeque<>();

        for (int l = n - 1; l >= 0; l--) {
            long x = a[l];
            long c = 1;
            while (!q.isEmpty() && q.peekFirst()[0] <= x) {
                long[] t = q.pollFirst();
                ops += (x - t[0]) * t[1];
                c += t[1];
            }
            q.offerFirst(new long[]{x, c});

            while (ops > k) {
                long[] b = q.peekLast();
                ops -= (b[0] - a[r]);
                b[1]--;
                if (b[1] == 0) {
                    q.pollLast();
                }
                r--;
            }

            ans += (r - l + 1);
        }

        return ans;
    }
}