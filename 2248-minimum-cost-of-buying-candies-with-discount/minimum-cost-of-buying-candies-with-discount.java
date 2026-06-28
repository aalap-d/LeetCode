import java.util.Arrays;

class Solution {
    public int minimumCost(int[] c) {
        Arrays.sort(c);
        int s = 0;
        int n = c.length;
        for (int i = n - 1; i >= 0; i--) {
            if ((n - 1 - i) % 3 != 2) {
                s += c[i];
            }
        }
        return s;
    }
}