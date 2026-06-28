class Solution {
    public int largestAltitude(int[] g) {
        int m = 0;
        int c = 0;
        for (int x : g) {
            c += x;
            if (c > m) {
                m = c;
            }
        }
        return m;
    }
}