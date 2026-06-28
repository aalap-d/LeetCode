public class Solution {
    public char processStr(String s, long k) {
        k++; 
        
        int n = s.length();
        long[] l = new long[n + 1];
        l[0] = 0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                l[i + 1] = Math.max(0, l[i] - 1);
            } else if (c == '#') {
                if (l[i] > Long.MAX_VALUE / 2) {
                    l[i + 1] = Long.MAX_VALUE;
                } else {
                    l[i + 1] = l[i] * 2;
                }
            } else if (c == '%') {
                l[i + 1] = l[i];
            } else {
                l[i + 1] = l[i] + 1;
            }
        }
        
        if (k < 1 || k > l[n]) {
            return '.';
        }
        
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long p = l[i];
            
            if (k > p) {
                if (c == '#') {
                    k = k - p;
                }
            } else {
                if (c == '%') {
                    k = p - k + 1;
                }
            }
            
            if (k == p + 1 && c != '*' && c != '#' && c != '%') {
                return c;
            }
        }
        
        return '.';
    }
}