import java.util.Arrays;

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        char[] t = s.toCharArray();
        Arrays.sort(t);

        if (Arrays.equals(a, t)) {
            return 0;
        }

        if (n == 2) {
            return -1;
        }

        char mn = t[0];
        char mx = t[n - 1];

        if (a[0] == mn || a[n - 1] == mx) {
            return 1;
        }

        int cmn = 0;
        int cmx = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == mn) cmn++;
            if (a[i] == mx) cmx++;
        }

        if (a[0] == mx && cmx == 1 && a[n - 1] == mn && cmn == 1) {
            return 3;
        }

        return 2;
    }
}