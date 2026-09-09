class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long p = 1000;
        while (n >= p) {
            ans += (n - p + 1);
            if (p > Long.MAX_VALUE / 1000) {
                break;
            }
            p *= 1000;
        }
        return ans;
    }
}