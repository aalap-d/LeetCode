import java.util.Arrays;

class Solution {
    public int missingInteger(int[] a) {
        int s = a[0];
        int n = a.length;
        
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1] + 1) {
                s += a[i];
            } else {
                break;
            }
        }
        
        Arrays.sort(a);
        
        for (int i = 0; i < n; i++) {
            if (a[i] == s) {
                s++;
            }
        }
        
        return s;
    }
}