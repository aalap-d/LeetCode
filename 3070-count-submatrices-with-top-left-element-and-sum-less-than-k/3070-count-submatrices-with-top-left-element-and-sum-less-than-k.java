class Solution {
    public int countSubmatrices(int[][] grid, int k) {

    int rows = grid.length;
    int cols = grid[0].length;

    int total = 0;

    for (int i = 0; i < rows; i++) {

        for (int j = 0; j < cols; j++) {

            int up = 0;
            if (i > 0) {
                up = grid[i - 1][j];
            }

            int left = 0;
            if (j > 0) {
                left = grid[i][j - 1];
            }

            int diag = 0;
            if (i > 0 && j > 0) {
                diag = grid[i - 1][j - 1];
            }

            int curr = grid[i][j] + up + left - diag;

            grid[i][j] = curr;

            if (curr <= k) {
                total++;
            }
        }
    }

    return total;
}
}