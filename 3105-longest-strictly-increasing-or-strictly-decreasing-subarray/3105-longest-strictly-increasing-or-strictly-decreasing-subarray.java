class Solution {
    public int longestMonotonicSubarray(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        
        int m = 1;
        int inc = 1;
        int dec = 1;
        
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                inc++;
                dec = 1;
            } else if (a[i] < a[i - 1]) {
                dec++;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            m = Math.max(m, Math.max(inc, dec));
        }
        
        return m;
    }
}