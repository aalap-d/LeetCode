class Solution {
    public int longestSubsequence(int[] a) {
        int x = 0;
        int c = 0;
        for (int i : a) {
            x ^= i;
            if (i != 0) c++;
        }
        if (x != 0) return a.length;
        return c > 0 ? a.length - 1 : 0;
    }
}