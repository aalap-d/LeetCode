class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int d1 = 0, d2 = 0, res = Integer.MAX_VALUE;
        String ss = s + s;

        for (int i = 0; i < 2 * n; i++) {
            if (ss.charAt(i) != (i % 2 == 0 ? '0' : '1')) d1++;
            if (ss.charAt(i) != (i % 2 == 0 ? '1' : '0')) d2++;

            if (i >= n) {
                if (ss.charAt(i - n) != ((i - n) % 2 == 0 ? '0' : '1')) d1--;
                if (ss.charAt(i - n) != ((i - n) % 2 == 0 ? '1' : '0')) d2--;
            }

            if (i >= n - 1) {
                res = Math.min(res, Math.min(d1, d2));
            }
        }

        return res;
    }
}
