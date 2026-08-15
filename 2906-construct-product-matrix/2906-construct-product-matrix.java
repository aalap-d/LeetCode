class Solution {
    public int[][] constructProductMatrix(int[][] grid) {

    int rows = grid.length;
    int cols = grid[0].length;

    int[][] result = new int[rows][cols];

    long running = 1;

    for (int i = 0; i < rows; i++) {

        for (int j = 0; j < cols; j++) {

            result[i][j] = (int) running;

            long val = grid[i][j];
            running = (running * val) % 12345;
        }
    }

    running = 1;

    for (int i = rows - 1; i >= 0; i--) {

        for (int j = cols - 1; j >= 0; j--) {

            long curr = result[i][j] * running;
            result[i][j] = (int) (curr % 12345);

            long val = grid[i][j];
            running = (running * val) % 12345;
        }
    }

    return result;
}
}