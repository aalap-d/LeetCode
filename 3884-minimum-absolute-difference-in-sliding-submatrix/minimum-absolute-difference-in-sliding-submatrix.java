class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {

    int rows = grid.length;
    int cols = grid[0].length;

    int[][] result = new int[rows - k + 1][cols - k + 1];

    int[] temp = new int[k * k];

    for (int i = 0; i <= rows - k; i++) {

        for (int j = 0; j <= cols - k; j++) {

            int idx = 0;

            for (int x = i; x < i + k; x++) {
                for (int y = j; y < j + k; y++) {
                    temp[idx] = grid[x][y];
                    idx++;
                }
            }

            Arrays.sort(temp);

            int minDiff = Integer.MAX_VALUE;

            for (int t = 1; t < temp.length; t++) {

                int diff = temp[t] - temp[t - 1];

                if (temp[t] != temp[t - 1]) {
                    if (diff < minDiff) {
                        minDiff = diff;
                    }
                }
            }

            if (minDiff == Integer.MAX_VALUE) {
                result[i][j] = 0;
            } else {
                result[i][j] = minDiff;
            }
        }
    }

    return result;
}
}