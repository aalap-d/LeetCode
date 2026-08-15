class Solution {
    public int largestSubmatrix(int[][] grid) {

    int rows = grid.length;
    int cols = grid[0].length;
    int bestArea = 0;

    for (int i = 0; i < rows; i++) {

        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == 1 && i != 0) {
                grid[i][j] = grid[i][j] + grid[i - 1][j];
            }
        }

        int[] heights = new int[cols];
        for (int k = 0; k < cols; k++) {
            heights[k] = grid[i][k];
        }

        Arrays.sort(heights);

        for (int j = cols - 1; j >= 0; j--) {

            int width = cols - j;
            int currArea = heights[j] * width;

            if (currArea > bestArea) {
                bestArea = currArea;
            }
        }
    }

    return bestArea;
}
}