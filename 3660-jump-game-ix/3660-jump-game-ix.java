class Solution {
    public int[] maxValue(int[] a) {
        int n = a.length;
        int[] r = new int[n];
        if (n == 0) return r;
        
        int[] ml = new int[n];
        int[] mr = new int[n];
        
        ml[0] = a[0];
        for (int i = 1; i < n; i++) {
            ml[i] = Math.max(ml[i - 1], a[i]);
        }
        
        mr[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            mr[i] = Math.min(mr[i + 1], a[i]);
        }
        
        int s = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || ml[i] <= mr[i + 1]) {
                int m = ml[i];
                for (int j = s; j <= i; j++) {
                    r[j] = m;
                }
                s = i + 1;
            }
        }
        
        return r;
    }
}