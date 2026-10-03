class Solution {
    public int longestValidParentheses(String s) {
        int l = 0, r = 0, m = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                m = Math.max(m, 2 * r);
            } else if (r > l) {
                l = 0;
                r = 0;
            }
        }
        l = 0;
        r = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                m = Math.max(m, 2 * l);
            } else if (l > r) {
                l = 0;
                r = 0;
            }
        }
        return m;
    }
}