class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String res = "";
        int minL = n + 1;
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') {
                    c++;
                }
                if (c == k) {
                    int l = j - i + 1;
                    String sub = s.substring(i, j + 1);
                    if (l < minL) {
                        minL = l;
                        res = sub;
                    } else if (l == minL) {
                        if (res.equals("") || sub.compareTo(res) < 0) {
                            res = sub;
                        }
                    }
                    break;
                }
            }
        }
        return res;
    }
}