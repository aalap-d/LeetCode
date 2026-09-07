class Solution {
    public int distinctSubseqII(String s) {
        int m = 1_000_000_007;
        int[] last = new int[26];
        int cur = 0;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            int add = (cur + 1 - last[c] + m) % m;
            cur = (cur + add) % m;
            last[c] = (last[c] + add) % m;
        }

        return cur;
    }
}
