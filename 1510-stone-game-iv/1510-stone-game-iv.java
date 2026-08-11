class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] d = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k * k <= i; k++) {
                if (!d[i - k * k]) {
                    d[i] = true;
                    break;
                }
            }
        }
        
        return d[n];
    }
}