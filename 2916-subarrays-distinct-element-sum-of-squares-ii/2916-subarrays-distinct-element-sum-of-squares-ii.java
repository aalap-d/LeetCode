import java.util.HashMap;
import java.util.Map;

class Solution {
    public int sumCounts(int[] nums) {
        int n = nums.length;
        long m = 1_000_000_007L;
        Node tr = new Node(1, n);
        Map<Integer, Integer> p = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int l = p.getOrDefault(x, 0) + 1;
            int r = i + 1;
            tr.add(l, r, 1);
            p.put(x, r);
            ans = (ans + tr.s2) % m;
        }

        return (int) (ans % m);
    }

    static class Node {
        int l, r;
        long s1, s2, lz;
        Node lc, rc;
        static final long MOD = 1_000_000_007L;

        Node(int l, int r) {
            this.l = l;
            this.r = r;
            if (l < r) {
                int mid = (l + r) >> 1;
                lc = new Node(l, mid);
                rc = new Node(mid + 1, r);
            }
        }

        void apply(long v) {
            long len = r - l + 1;
            v %= MOD;
            s2 = (s2 + 2 * v * s1 + v * v % MOD * len) % MOD;
            s1 = (s1 + v * len) % MOD;
            lz = (lz + v) % MOD;
        }

        void push() {
            if (lz != 0) {
                lc.apply(lz);
                rc.apply(lz);
                lz = 0;
            }
        }

        void pull() {
            s1 = (lc.s1 + rc.s1) % MOD;
            s2 = (lc.s2 + rc.s2) % MOD;
        }

        void add(int ql, int qr, long v) {
            if (ql <= this.l && this.r <= qr) {
                apply(v);
                return;
            }
            push();
            int mid = (this.l + this.r) >> 1;
            if (ql <= mid) lc.add(ql, qr, v);
            if (qr > mid) rc.add(ql, qr, v);
            pull();
        }
    }
}