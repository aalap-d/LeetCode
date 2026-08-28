class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int h = n / 2;
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int odd = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 != 0) {
                if (odd != -1) return "";
                odd = i;
            }
        }
        int[] lcnt = new int[26];
        for (int i = 0; i < 26; i++) {
            lcnt[i] = cnt[i] / 2;
        }
        char oc = odd == -1 ? 0 : (char) ('a' + odd);
        int[] tarr = new int[h];
        for (int i = 0; i < h; i++) {
            tarr[i] = target.charAt(i) - 'a';
        }
        int[] l = new int[h];
        int[] rem = lcnt.clone();
        boolean ok = true;
        for (int i = 0; i < h; i++) {
            int c = tarr[i];
            if (rem[c] > 0) {
                l[i] = c;
                rem[c]--;
            } else {
                ok = false;
                break;
            }
        }
        if (ok) {
            String cand = build(l, oc, n);
            if (cand.compareTo(target) > 0) return cand;
        }
        for (int p = h - 1; p >= 0; p--) {
            int[] r2 = lcnt.clone();
            int[] l2 = new int[h];
            boolean poss = true;
            for (int i = 0; i < p; i++) {
                int c = tarr[i];
                if (r2[c] > 0) {
                    l2[i] = c;
                    r2[c]--;
                } else {
                    poss = false;
                    break;
                }
            }
            if (!poss) continue;
            int tc = tarr[p];
            boolean found = false;
            for (int c = tc + 1; c < 26; c++) {
                if (r2[c] > 0) {
                    l2[p] = c;
                    r2[c]--;
                    found = true;
                    break;
                }
            }
            if (!found) continue;
            for (int i = p + 1; i < h; i++) {
                for (int c = 0; c < 26; c++) {
                    if (r2[c] > 0) {
                        l2[i] = c;
                        r2[c]--;
                        break;
                    }
                }
            }
            String cand = build(l2, oc, n);
            if (cand.compareTo(target) > 0) return cand;
        }
        return "";
    }

    private String build(int[] l, char oc, int n) {
        StringBuilder sb = new StringBuilder();
        int h = l.length;
        for (int i = 0; i < h; i++) {
            sb.append((char) ('a' + l[i]));
        }
        if (n % 2 != 0) {
            sb.append(oc);
        }
        for (int i = h - 1; i >= 0; i--) {
            sb.append((char) ('a' + l[i]));
        }
        return sb.toString();
    }
}