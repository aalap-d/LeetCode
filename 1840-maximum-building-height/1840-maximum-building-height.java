import java.util.Arrays;

class Solution {
    public int maxBuilding(int n, int[][] r) {
        int m = r.length + 2;
        int[][] a = new int[m][2];
        
        for (int i = 0; i < r.length; i++) {
            a[i] = r[i];
        }
        a[m - 2] = new int[]{1, 0};
        a[m - 1] = new int[]{n, n - 1};
        
        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));
        
        for (int i = 1; i < m; i++) {
            a[i][1] = Math.min(a[i][1], a[i - 1][1] + a[i][0] - a[i - 1][0]);
        }
        
        for (int i = m - 2; i >= 0; i--) {
            a[i][1] = Math.min(a[i][1], a[i + 1][1] + a[i + 1][0] - a[i][0]);
        }
        
        int ans = 0;
        for (int i = 1; i < m; i++) {
            int d = a[i][0] - a[i - 1][0];
            int h1 = a[i - 1][1];
            int h2 = a[i][1];
            ans = Math.max(ans, (h1 + h2 + d) / 2);
        }
        
        return ans;
    }
}