import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }

        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        dfs(s, 0, 0, l, r, sb, res);
        return new ArrayList<>(res);
    }

    private void dfs(String s, int idx, int bal, int l, int r, StringBuilder sb, Set<String> res) {
        if (bal < 0) {
            return;
        }

        if (idx == s.length()) {
            if (l == 0 && r == 0 && bal == 0) {
                res.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(idx);

        if (c == '(' && l > 0) {
            dfs(s, idx + 1, bal, l - 1, r, sb, res);
        }
        if (c == ')' && r > 0) {
            dfs(s, idx + 1, bal, l, r - 1, sb, res);
        }

        sb.append(c);
        int nb = bal + (c == '(' ? 1 : (c == ')' ? -1 : 0));
        dfs(s, idx + 1, nb, l, r, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }
}