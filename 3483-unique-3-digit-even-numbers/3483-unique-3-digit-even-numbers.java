class Solution {
    public int totalNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int d : digits) {
            cnt[d]++;
        }

        int res = 0;

        for (int i = 100; i < 1000; i += 2) {
            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;

            int[] cur = new int[10];
            cur[a]++;
            cur[b]++;
            cur[c]++;

            if (cur[a] <= cnt[a] && cur[b] <= cnt[b] && cur[c] <= cnt[c]) {
                res++;
            }
        }

        return res;
    }
}