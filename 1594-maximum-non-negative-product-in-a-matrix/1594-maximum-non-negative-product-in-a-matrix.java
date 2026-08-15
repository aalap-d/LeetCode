class Solution {
    public int maxProductPath(int[][] grid) {

    int rows = grid.length;
    int cols = grid[0].length;

    long[][] maxDp = new long[rows][cols];
    long[][] minDp = new long[rows][cols];

    maxDp[0][0] = grid[0][0];
    minDp[0][0] = grid[0][0];

    for (int i = 1; i < rows; i++) {
        long val = grid[i][0];
        maxDp[i][0] = maxDp[i - 1][0] * val;
        minDp[i][0] = minDp[i - 1][0] * val;
    }

    for (int j = 1; j < cols; j++) {
        long val = grid[0][j];
        maxDp[0][j] = maxDp[0][j - 1] * val;
        minDp[0][j] = minDp[0][j - 1] * val;
    }

    for (int i = 1; i < rows; i++) {

        for (int j = 1; j < cols; j++) {

            long curr = grid[i][j];

            long fromTopMax = maxDp[i - 1][j] * curr;
            long fromTopMin = minDp[i - 1][j] * curr;

            long fromLeftMax = maxDp[i][j - 1] * curr;
            long fromLeftMin = minDp[i][j - 1] * curr;

            long maxVal = fromTopMax;
            if (fromTopMin > maxVal) maxVal = fromTopMin;
            if (fromLeftMax > maxVal) maxVal = fromLeftMax;
            if (fromLeftMin > maxVal) maxVal = fromLeftMin;

            long minVal = fromTopMax;
            if (fromTopMin < minVal) minVal = fromTopMin;
            if (fromLeftMax < minVal) minVal = fromLeftMax;
            if (fromLeftMin < minVal) minVal = fromLeftMin;

            maxDp[i][j] = maxVal;
            minDp[i][j] = minVal;
        }
    }

    long finalVal = maxDp[rows - 1][cols - 1];

    if (finalVal < 0) {
        return -1;
    }

    int mod = 1000000007;
    return (int)(finalVal % mod);
}
}