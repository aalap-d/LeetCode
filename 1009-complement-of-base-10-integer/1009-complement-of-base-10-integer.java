class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int m = 0;
        int t = n;
        while (t > 0) {
            m = (m << 1) | 1;
            t >>= 1;
        }
        return n ^ m;
    }
}