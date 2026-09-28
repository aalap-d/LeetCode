class Solution {
    public int maxDepth(String s) {
        int cur = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cur++;
                if (cur > max) {
                    max = cur;
                }
            } else if (c == ')') {
                cur--;
            }
        }
        return max;
    }
}