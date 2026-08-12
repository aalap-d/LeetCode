import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] a, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int l = 0, r = 0, x = 0;
        int n = a.length;
        
        while (r < n) {
            m.put(a[r], m.getOrDefault(a[r], 0) + 1);
            
            while (m.get(a[r]) > k) {
                m.put(a[l], m.get(a[l]) - 1);
                l++;
            }
            
            x = Math.max(x, r - l + 1);
            r++;
        }
        
        return x;
    }
}