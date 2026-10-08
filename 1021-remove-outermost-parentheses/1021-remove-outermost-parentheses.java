class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int d = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (d > 0) {
                    sb.append(c);
                }
                d++;
            } else {
                d--;
                if (d > 0) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}