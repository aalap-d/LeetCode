import java.util.TreeSet;

class Solution {
    public int[] getBiggestThree(int[][] g) {
        int m = g.length;
        int n = g[0].length;
        TreeSet<Integer> s = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                s.add(g[i][j]);
                if (s.size() > 3) {
                    s.pollFirst();
                }

                int k = 1;
                while (i + 2 * k < m && j - k >= 0 && j + k < n) {
                    int sum = 0;
                    int r = i;
                    int c = j;
                    
                    for (int x = 0; x < k; x++) sum += g[r++][c++];
                    for (int x = 0; x < k; x++) sum += g[r++][c--];
                    for (int x = 0; x < k; x++) sum += g[r--][c--];
                    for (int x = 0; x < k; x++) sum += g[r--][c++];
                    
                    s.add(sum);
                    if (s.size() > 3) {
                        s.pollFirst();
                    }
                    k++;
                }
            }
        }

        int sz = s.size();
        int[] res = new int[sz];
        for (int i = 0; i < sz; i++) {
            res[i] = s.pollLast();
        }
        
        return res;
    }
}