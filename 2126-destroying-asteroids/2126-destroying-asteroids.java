import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int m, int[] a) {
        Arrays.sort(a);
        long cur = m;
        for (int x : a) {
            if (cur < x) {
                return false;
            }
            cur += x;
        }
        return true;
    }
}