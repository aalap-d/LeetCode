import java.util.*;

class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Deque<Integer> st = new ArrayDeque<>();
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(i);
            } else if (c == ')') {
                int j = st.pop();
                p[i] = j;
                p[j] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int d = 1;

        while (i < n) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                i = p[i];
                d = -d;
            } else {
                sb.append(c);
            }
            i += d;
        }

        return sb.toString();
    }
}