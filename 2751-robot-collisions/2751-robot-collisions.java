import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] p, int[] h, String d) {
        int n = p.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        
        Arrays.sort(idx, (a, b) -> Integer.compare(p[a], p[b]));
        
        Deque<Integer> st = new ArrayDeque<>();
        
        for (int i : idx) {
            if (d.charAt(i) == 'R') {
                st.push(i);
            } else {
                while (!st.isEmpty() && d.charAt(st.peek()) == 'R' && h[i] > 0) {
                    int t = st.peek();
                    if (h[t] > h[i]) {
                        h[t] -= 1;
                        h[i] = 0;
                    } else if (h[t] < h[i]) {
                        h[i] -= 1;
                        h[t] = 0;
                        st.pop();
                    } else {
                        h[i] = 0;
                        h[t] = 0;
                        st.pop();
                    }
                }
                if (h[i] > 0) {
                    st.push(i);
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (h[i] > 0) {
                ans.add(h[i]);
            }
        }
        return ans;
    }
}