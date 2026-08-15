class Solution {
   public boolean canPartitionGrid(int[][] grid) {

    int rows = grid.length;
    int cols = grid[0].length;

    long[] rowSum = new long[rows];
    long[] colSum = new long[cols];

    long total = 0;

    for (int i = 0; i < rows; i++) {

        long tempRow = 0;

        for (int j = 0; j < cols; j++) {

            int val = grid[i][j];

            tempRow += val;
            colSum[j] += val;
            total += val;
        }

        rowSum[i] = tempRow;
    }

    if (total % 2 != 0) {
        return false;
    }

    long target = total / 2;

    long running = 0;

    for (int i = 0; i < rows - 1; i++) {

        running += rowSum[i];

        if (running == target) {
            return true;
        }
    }

    running = 0;

    for (int j = 0; j < cols - 1; j++) {

        running += colSum[j];

        if (running == target) {
            return true;
        }
    }

    return false;
}
}