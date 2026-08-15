class Solution {
   public boolean findRotation(int[][] mat, int[][] target) {

    int n = mat.length;

    boolean same = true;
    boolean rot90 = true;
    boolean rot180 = true;
    boolean rot270 = true;

    for (int i = 0; i < n; i++) {

        for (int j = 0; j < n; j++) {

            int val = mat[i][j];

            if (val != target[i][j]) {
                same = false;
            }

            if (val != target[j][n - 1 - i]) {
                rot90 = false;
            }

            if (val != target[n - 1 - i][n - 1 - j]) {
                rot180 = false;
            }

            if (val != target[n - 1 - j][i]) {
                rot270 = false;
            }
        }
    }

    return same || rot90 || rot180 || rot270;
}
}