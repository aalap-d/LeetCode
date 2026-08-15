class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            trailingZeros[i] = count;
        }

        int totalSwaps = 0;

     
        for (int i = 0; i < n; i++) {
            int requiredZeros = n - 1 - i;
            int foundIndex = -1;

            for (int j = i; j < n; j++) {
                if (trailingZeros[j] >= requiredZeros) {
                    foundIndex = j;
                    break;
                }
            }

            if (foundIndex == -1) return -1;

            for (int j = foundIndex; j > i; j--) {
                int temp = trailingZeros[j];
                trailingZeros[j] = trailingZeros[j - 1];
                trailingZeros[j - 1] = temp;
                totalSwaps++;
            }
        }

        return totalSwaps;
    }
}
