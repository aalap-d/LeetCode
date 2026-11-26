class Solution {
    public boolean canAliceWin(int n) {
        int c = 10;
        boolean w = false;
        while (n >= c && c > 0) {
            n -= c;
            c--;
            w = !w;
        }
        return w;
    }
}