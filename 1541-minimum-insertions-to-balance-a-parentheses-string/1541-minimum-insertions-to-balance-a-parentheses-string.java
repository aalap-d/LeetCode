class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int req = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                if (req % 2 != 0) {
                    ans++;
                    req--;
                }
                req += 2;
            } else {
                req--;
                if (req < 0) {
                    ans++;
                    req += 2;
                }
            }
        }

        return ans + req;
    }
}