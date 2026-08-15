class Solution {
   public int[][] reverseSubmatrix(int[][] grid, int startRow, int startCol, int size) {

    int top = 0;
    int bottom = size - 1;

    while (top < bottom) {

        int rowA = startRow + top;
        int rowB = startRow + bottom;

        for (int col = startCol; col < startCol + size; col++) {

            int temp = grid[rowA][col];
            grid[rowA][col] = grid[rowB][col];
            grid[rowB][col] = temp;
        }

        top++;
        bottom--;
    }

    return grid;
}
}