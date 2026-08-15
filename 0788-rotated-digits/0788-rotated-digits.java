class Solution {
    public int rotatedDigits(int n) {
        int c = 0;
        for (int i = 1; i <= n; i++) {
            int t = i;
            boolean v = true;
            boolean r = false;
            while (t > 0) {
                int d = t % 10;
                if (d == 3 || d == 4 || d == 7) {
                    v = false;
                    break;
                }
                if (d == 2 || d == 5 || d == 6 || d == 9) {
                    r = true;
                }
                t /= 10;
            }
            if (v && r) {
                c++;
            }
        }
        return c;
    }
}