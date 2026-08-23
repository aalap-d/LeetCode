class Solution {
    public boolean sumGame(String num) {
        int s1 = 0, s2 = 0, q1 = 0, q2 = 0;
        int n = num.length();
        int h = n / 2;
        
        for (int i = 0; i < h; i++) {
            char c = num.charAt(i);
            if (c == '?') q1++;
            else s1 += c - '0';
        }
        
        for (int i = h; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') q2++;
            else s2 += c - '0';
        }
        
        if ((q1 + q2) % 2 != 0) return true;
        
        return (s1 - s2) != 9 * (q2 - q1) / 2;
    }
}