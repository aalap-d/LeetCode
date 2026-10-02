import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder sb, int o, int c, int m) {
        if (sb.length() == m * 2) {
            res.add(sb.toString());
            return;
        }

        if (o < m) {
            sb.append('(');
            backtrack(res, sb, o + 1, c, m);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (c < o) {
            sb.append(')');
            backtrack(res, sb, o, c + 1, m);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}