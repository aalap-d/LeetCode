import java.util.*;

class Solution {
    static class Node {
        long w;
        List<Integer> id;

        Node(long w, List<Integer> id) {
            this.w = w;
            this.id = id;
        }
    }

    public int[] maximumWeight(List<List<Integer>> a) {
        int n = a.size();
        int[][] b = new int[n][4];
        for (int i = 0; i < n; i++) {
            b[i][0] = a.get(i).get(0);
            b[i][1] = a.get(i).get(1);
            b[i][2] = a.get(i).get(2);
            b[i][3] = i;
        }

        Arrays.sort(b, (x, y) -> x[1] != y[1] ? Integer.compare(x[1], y[1]) : Integer.compare(x[0], y[0]));

        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = b[i][1];
        }

        Node[][] dp = new Node[n + 1][5];
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new Node(0, new ArrayList<>());
            }
        }

        for (int i = 1; i <= n; i++) {
            int l = b[i - 1][0];
            int w = b[i - 1][2];
            int idx = b[i - 1][3];

            int p = bs(r, l);

            for (int k = 0; k <= 4; k++) {
                dp[i][k] = dp[i - 1][k];
            }

            for (int k = 1; k <= 4; k++) {
                Node prev = dp[p][k - 1];
                if (k == 1 || prev.w > 0 || !prev.id.isEmpty()) {
                    long nw = prev.w + w;
                    List<Integer> nid = new ArrayList<>(prev.id);
                    nid.add(idx);
                    Collections.sort(nid);

                    Node cand = new Node(nw, nid);
                    if (cmp(cand, dp[i][k]) > 0) {
                        dp[i][k] = cand;
                    }
                }
            }
        }

        Node ans = new Node(-1, new ArrayList<>());
        for (int k = 1; k <= 4; k++) {
            if (cmp(dp[n][k], ans) > 0) {
                ans = dp[n][k];
            }
        }

        int[] res = new int[ans.id.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.id.get(i);
        }
        return res;
    }

    private int bs(int[] r, int l) {
        int low = 0, high = r.length - 1, res = 0;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (r[mid] < l) {
                res = mid + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private int cmp(Node x, Node y) {
        if (x.w != y.w) {
            return Long.compare(x.w, y.w);
        }
        int s1 = x.id.size(), s2 = y.id.size();
        int min = Math.min(s1, s2);
        for (int i = 0; i < min; i++) {
            int v1 = x.id.get(i), v2 = y.id.get(i);
            if (v1 != v2) {
                return Integer.compare(v2, v1);
            }
        }
        return Integer.compare(s2, s1);
    }
}