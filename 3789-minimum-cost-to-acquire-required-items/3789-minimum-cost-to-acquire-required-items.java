class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;
        long n1 = need1;
        long n2 = need2;

        if (cb >= c1 + c2) {
            return n1 * c1 + n2 * c2;
        }

        long min = Math.min(n1, n2);
        long rem1 = n1 - min;
        long rem2 = n2 - min;

        long res = min * cb;
        res += rem1 * Math.min(c1, cb);
        res += rem2 * Math.min(c2, cb);

        long alt = Math.max(n1, n2) * cb;
        return Math.min(res, alt);
    }
}