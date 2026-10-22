class Solution {
    public int minOperations(int[] a) {
        int n = a.length;
        if (n <= 1) return 0;

        int p = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                p = i;
                break;
            }
        }

        boolean inc = true;
        for (int i = 0; i < n; i++) {
            if (a[(p + i) % n] != i) {
                inc = false;
                break;
            }
        }

        if (inc) {
            int c1 = p;
            int c2 = (n - p) % n + 2;
            return Math.min(c1, c2);
        }

        boolean dec = true;
        for (int i = 0; i < n; i++) {
            if (a[(p - i + n) % n] != i) {
                dec = false;
                break;
            }
        }

        if (dec) {
            int c1 = 1 + (n - 1 - p);
            int c2 = 1 + (p + 1) % n;
            return Math.min(c1, c2);
        }

        return -1;
    }
}