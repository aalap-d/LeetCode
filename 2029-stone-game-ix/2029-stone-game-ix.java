class Solution {
    public boolean stoneGameIX(int[] s) {
        int[] c = new int[3];
        
        for (int x : s) {
            c[x % 3]++;
        }
        
        if (c[0] % 2 == 0) {
            return c[1] > 0 && c[2] > 0;
        }
        
        return Math.abs(c[1] - c[2]) > 2;
    }
}