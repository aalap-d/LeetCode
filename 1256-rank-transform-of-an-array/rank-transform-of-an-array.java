import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] arrayRankTransform(int[] a) {
        int n = a.length;
        int[] b = a.clone();
        Arrays.sort(b);
        
        HashMap<Integer, Integer> m = new HashMap<>();
        int r = 1;
        for (int i = 0; i < n; i++) {
            if (!m.containsKey(b[i])) {
                m.put(b[i], r);
                r++;
            }
        }
        
        for (int i = 0; i < n; i++) {
            a[i] = m.get(a[i]);
        }
        
        return a;
    }
}