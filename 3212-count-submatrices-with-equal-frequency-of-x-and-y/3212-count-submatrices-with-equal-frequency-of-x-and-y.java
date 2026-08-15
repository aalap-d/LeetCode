class Solution {
    public int numberOfSubmatrices(char[][] grid) {

    int rows = grid.length;
    int cols = grid[0].length;

    int[] countX = new int[cols];
    int[] countY = new int[cols];

    int result = 0;

    for (int i = 0; i < rows; i++) {

        int runningX = 0;
        int runningY = 0;

        for (int j = 0; j < cols; j++) {

            char ch = grid[i][j];

            if (ch == 'X') {
                countX[j] = countX[j] + 1;
            } else if (ch == 'Y') {
                countY[j] = countY[j] + 1;
            }

            runningX += countX[j];
            runningY += countY[j];

            if (runningX == runningY) {
                if (runningX > 0) {
                    result++;
                }
            }
        }
    }

    return result;
}
}