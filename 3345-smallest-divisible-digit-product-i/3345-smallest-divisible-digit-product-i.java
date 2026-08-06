class Solution {
    public int smallestNumber(int n, int t) {
        int x = n;
        while (true) {
            if (p(x) % t == 0) return x;
            x++;
        }
    }

    private int p(int x) {
        int p = 1;
        while (x > 0) {
            p *= x % 10;
            x /= 10;
        }
        return p;
    }
}