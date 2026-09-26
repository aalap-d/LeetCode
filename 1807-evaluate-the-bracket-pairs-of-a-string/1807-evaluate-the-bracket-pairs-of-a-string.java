import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> m = new HashMap<>();
        for (List<String> p : knowledge) {
            m.put(p.get(0), p.get(1));
        }

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;

        while (i < n) {
            char c = s.charAt(i);
            if (c == '(') {
                int j = i + 1;
                while (j < n && s.charAt(j) != ')') {
                    j++;
                }
                String k = s.substring(i + 1, j);
                sb.append(m.getOrDefault(k, "?"));
                i = j + 1;
            } else {
                sb.append(c);
                i++;
            }
        }

        return sb.toString();
    }
}