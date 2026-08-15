import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] c, int[][] o) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<Long> s = new HashSet<>();
        
        for (int i = 0; i < o.length; i++) {
            long h = (((long) o[i][0]) << 32) | (o[i][1] & 0xFFFFFFFFL);
            s.add(h);
        }

        int x = 0;
        int y = 0;
        int d = 0;
        int mx = 0;

        for (int i = 0; i < c.length; i++) {
            if (c[i] == -2) {
                d = (d + 3) % 4;
            } else if (c[i] == -1) {
                d = (d + 1) % 4;
            } else {
                for (int j = 0; j < c[i]; j++) {
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];
                    long h = (((long) nx) << 32) | (ny & 0xFFFFFFFFL);
                    
                    if (s.contains(h)) {
                        break;
                    }
                    
                    x = nx;
                    y = ny;
                    mx = Math.max(mx, x * x + y * y);
                }
            }
        }
        
        return mx;
    }
}