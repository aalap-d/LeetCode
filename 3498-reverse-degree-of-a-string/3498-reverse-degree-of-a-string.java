class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int v = 26 - (c - 'a');
            int p = i + 1;
            ans += v * p;
        }
        return ans;
    }
}