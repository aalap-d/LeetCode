import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] v) {
        Arrays.sort(v, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        int c = 0;
        int m = -1;
        
        for (int[] x : v) {
            if (x[1] > m) {
                c++;
                m = x[1];
            }
        }
        
        return c;
    }
}