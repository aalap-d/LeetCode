class Solution {

    public int maximumAmount(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][3];

        int NEG = -1000000000; 
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dp[r][c][0] = NEG;
                dp[r][c][1] = NEG;
                dp[r][c][2] = NEG;
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                int currVal = grid[r][c];

                if (r == 0 && c == 0) {
                    dp[0][0][0] = currVal;

                   
                    if (currVal < 0) {
                        dp[0][0][1] = 0;
                    }

                    continue; 
                }

                for (int usedSkips = 0; usedSkips < 3; usedSkips++) {

                    int bestPrev = NEG;


                    if (r > 0) {
                        bestPrev = Math.max(bestPrev, dp[r - 1][c][usedSkips]);
                    }


                    if (c > 0) {
                        bestPrev = Math.max(bestPrev, dp[r][c - 1][usedSkips]);
                    }

                    if (bestPrev != NEG) {
                        dp[r][c][usedSkips] = Math.max(
                                dp[r][c][usedSkips],
                                bestPrev + currVal
                        );
                    }
                }

   
                if (currVal < 0) {

                    for (int usedSkips = 1; usedSkips < 3; usedSkips++) {

                        int bestPrev = NEG;

                        if (r > 0) {
                            bestPrev = Math.max(bestPrev, dp[r - 1][c][usedSkips - 1]);
                        }

                        if (c > 0) {
                            bestPrev = Math.max(bestPrev, dp[r][c - 1][usedSkips - 1]);
                        }

  
                        if (bestPrev != NEG) {
                            dp[r][c][usedSkips] = Math.max(
                                    dp[r][c][usedSkips],
                                    bestPrev
                            );
                        }
                    }
                }
            }
        }

        int lastR = rows - 1;
        int lastC = cols - 1;

        int ans = dp[lastR][lastC][0];
        ans = Math.max(ans, dp[lastR][lastC][1]);
        ans = Math.max(ans, dp[lastR][lastC][2]);

        return ans;
    }
}