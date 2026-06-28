class Solution {
    public char[][] rotateTheBox(char[][] b) {
        int m = b.length;
        int n = b[0].length;
        char[][] r = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                r[i][j] = '.';
            }
        }
        
        for (int i = 0; i < m; i++) {
            int e = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (b[i][j] == '*') {
                    r[j][m - 1 - i] = '*';
                    e = j - 1;
                } else if (b[i][j] == '#') {
                    r[e][m - 1 - i] = '#';
                    e--;
                }
            }
        }
        
        return r;
    }
}