class Solution {
    public String processStr(String s) {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (r.length() > 0) {
                    r.deleteCharAt(r.length() - 1);
                }
            } else if (c == '#') {
                r.append(r.toString());
            } else if (c == '%') {
                r.reverse();
            } else {
                r.append(c);
            }
        }
        return r.toString();
    }
}