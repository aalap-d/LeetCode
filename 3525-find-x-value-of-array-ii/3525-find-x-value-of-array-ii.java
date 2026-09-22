class Solution {
    int n, k;
    int[] prod;
    int[][][] cnt;

    void pull(int u) {
        int l = 2 * u, r = 2 * u + 1;
        prod[u] = (prod[l] * prod[r]) % k;
        for (int rem = 0; rem < k; rem++) {
            int rightRem = (rem * prod[l]) % k;
            for (int x = 0; x < k; x++) {
                cnt[u][rem][x] = cnt[l][rem][x] + cnt[r][rightRem][x];
            }
        }
    }

    void build(int u, int l, int r, int[] nums) {
        if (l == r) {
            prod[u] = nums[l] % k;
            for (int rem = 0; rem < k; rem++) {
                int val = (rem * prod[u]) % k;
                cnt[u][rem][val] = 1;
            }
            return;
        }
        int m = l + (r - l) / 2;
        build(2 * u, l, m, nums);
        build(2 * u + 1, m + 1, r, nums);
        pull(u);
    }

    void update(int u, int l, int r, int idx, int val) {
        if (l == r) {
            prod[u] = val % k;
            for (int rem = 0; rem < k; rem++) {
                for (int x = 0; x < k; x++) {
                    cnt[u][rem][x] = 0;
                }
                int v = (rem * prod[u]) % k;
                cnt[u][rem][v] = 1;
            }
            return;
        }
        int m = l + (r - l) / 2;
        if (idx <= m) update(2 * u, l, m, idx, val);
        else update(2 * u + 1, m + 1, r, idx, val);
        pull(u);
    }

    // Returns the product of the queried range modulo k via prodOut[0]
    int query(int u, int l, int r, int ql, int qr, int curRem, int targetX, int[] prodOut) {
        if (ql <= l && r <= qr) {
            prodOut[0] = prod[u];
            return cnt[u][curRem][targetX];
        }
        int m = l + (r - l) / 2;
        if (qr <= m) {
            return query(2 * u, l, m, ql, qr, curRem, targetX, prodOut);
        } else if (ql > m) {
            return query(2 * u + 1, m + 1, r, ql, qr, curRem, targetX, prodOut);
        } else {
            int[] leftProd = new int[1];
            int ansL = query(2 * u, l, m, ql, qr, curRem, targetX, leftProd);
            
            int nextRem = (curRem * leftProd[0]) % k;
            int[] rightProd = new int[1];
            int ansR = query(2 * u + 1, m + 1, r, ql, qr, nextRem, targetX, rightProd);
            
            prodOut[0] = (leftProd[0] * rightProd[0]) % k;
            return ansL + ansR;
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;
        this.prod = new int[4 * n];
        this.cnt = new int[4 * n][k][k];

        build(1, 0, n - 1, nums);

        int q = queries.length;
        int[] res = new int[q];
        int[] dummyProd = new int[1];

        for (int i = 0; i < q; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int targetX = queries[i][3];

            update(1, 0, n - 1, idx, val);
            
            // Pass (1 % k) instead of 1 to handle k = 1 correctly
            res[i] = query(1, 0, n - 1, start, n - 1, 1 % k, targetX, dummyProd);
        }

        return res;
    }
}