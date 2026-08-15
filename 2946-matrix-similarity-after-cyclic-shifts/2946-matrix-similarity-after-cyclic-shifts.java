class Solution {
   public boolean areSimilar(int[][] matrix, int k) {

    int rows = matrix.length;
    int cols = matrix[0].length;

    int shift = k % cols;

    if (shift == 0) {
        return true;
    }

    for (int i = 0; i < rows; i++) {

        for (int j = 0; j < cols; j++) {

            int current = matrix[i][j];

            if (i % 2 == 0) {

                int newPos = (j + shift) % cols;

                if (current != matrix[i][newPos]) {
                    return false;
                }

            } else {

                int newPos = j - shift;
                if (newPos < 0) {
                    newPos += cols;
                }

                if (current != matrix[i][newPos]) {
                    return false;
                }
            }
        }
    }

    return true;
}
}