class Solution {
   public boolean canPartitionGrid(int[][] grid) {

    int rows = grid.length;
    int cols = grid[0].length;

    long total = 0;

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            total += grid[i][j];
        }
    }

    java.util.HashSet<Integer> seen = new java.util.HashSet<>();

    long topSum = 0;

    for (int i = 0; i < rows - 1; i++) {

        for (int j = 0; j < cols; j++) {
            topSum += grid[i][j];
            seen.add(grid[i][j]);
        }

        long bottomSum = total - topSum;

        if (topSum == bottomSum) {
            return true;
        }

        if (topSum > bottomSum) {

            long diff = topSum - bottomSum;

            if (diff <= Integer.MAX_VALUE) {

                int d = (int) diff;

                if (cols == 1) {

                    if (i > 0 && (grid[0][0] == d || grid[i][0] == d)) {
                        return true;
                    }

                } else {

                    if (i == 0) {

                        if (grid[0][0] == d || grid[0][cols - 1] == d) {
                            return true;
                        }

                    } else {

                        if (seen.contains(d)) {
                            return true;
                        }
                    }
                }
            }
        }
    }

    seen.clear();

    long bottomAccum = 0;

    for (int i = rows - 1; i > 0; i--) {

        for (int j = 0; j < cols; j++) {
            bottomAccum += grid[i][j];
            seen.add(grid[i][j]);
        }

        long topRemain = total - bottomAccum;

        if (bottomAccum > topRemain) {

            long diff = bottomAccum - topRemain;

            if (diff <= Integer.MAX_VALUE) {

                int d = (int) diff;

                if (cols == 1) {

                    if (i < rows - 1 && (grid[i][0] == d || grid[rows - 1][0] == d)) {
                        return true;
                    }

                } else {

                    if (i == rows - 1) {

                        if (grid[rows - 1][0] == d || grid[rows - 1][cols - 1] == d) {
                            return true;
                        }

                    } else {

                        if (seen.contains(d)) {
                            return true;
                        }
                    }
                }
            }
        }
    }

    seen.clear();

    long leftSum = 0;

    for (int j = 0; j < cols - 1; j++) {

        for (int i = 0; i < rows; i++) {
            leftSum += grid[i][j];
            seen.add(grid[i][j]);
        }

        long rightSum = total - leftSum;

        if (leftSum == rightSum) {
            return true;
        }

        if (leftSum > rightSum) {

            long diff = leftSum - rightSum;

            if (diff <= Integer.MAX_VALUE) {

                int d = (int) diff;

                if (rows == 1) {

                    if (j > 0 && (grid[0][0] == d || grid[0][j] == d)) {
                        return true;
                    }

                } else {

                    if (j == 0) {

                        if (grid[0][0] == d || grid[rows - 1][0] == d) {
                            return true;
                        }

                    } else {

                        if (seen.contains(d)) {
                            return true;
                        }
                    }
                }
            }
        }
    }

    seen.clear();

    long rightAccum = 0;

    for (int j = cols - 1; j > 0; j--) {

        for (int i = 0; i < rows; i++) {
            rightAccum += grid[i][j];
            seen.add(grid[i][j]);
        }

        long leftRemain = total - rightAccum;

        if (rightAccum > leftRemain) {

            long diff = rightAccum - leftRemain;

            if (diff <= Integer.MAX_VALUE) {

                int d = (int) diff;

                if (rows == 1) {

                    if (j < cols - 1 && (grid[0][j] == d || grid[0][cols - 1] == d)) {
                        return true;
                    }

                } else {

                    if (j == cols - 1) {

                        if (grid[0][cols - 1] == d || grid[rows - 1][cols - 1] == d) {
                            return true;
                        }

                    } else {

                        if (seen.contains(d)) {
                            return true;
                        }
                    }
                }
            }
        }
    }

    return false;
}
}