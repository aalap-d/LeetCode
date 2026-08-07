class Solution {
    public String smallestNumber(String num, long t) {
        // Step 1: Prime factorize t into 2, 3, 5, 7
        long temp = t;
        int r2 = 0, r3 = 0, r5 = 0, r7 = 0;
        while (temp % 2 == 0) { temp /= 2; r2++; }
        while (temp % 3 == 0) { temp /= 3; r3++; }
        while (temp % 5 == 0) { temp /= 5; r5++; }
        while (temp % 7 == 0) { temp /= 7; r7++; }
        if (temp > 1) return "-1"; // Prime factor > 7 cannot be formed by single digits

        int n = num.length();
        int[] p2 = new int[n + 1];
        int[] p3 = new int[n + 1];
        int[] p5 = new int[n + 1];
        int[] p7 = new int[n + 1];
        int z = -1;

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (c == '0') {
                z = i;
                break;
            }
            int v = c - '0';
            p2[i + 1] = p2[i] + f(v, 2);
            p3[i + 1] = p3[i] + f(v, 3);
            p5[i + 1] = p5[i] + f(v, 5);
            p7[i + 1] = p7[i] + f(v, 7);
        }

        // Check if num itself is valid (no zeros and product divisible by t)
        if (z == -1 && p2[n] >= r2 && p3[n] >= r3 && p5[n] >= r5 && p7[n] >= r7) {
            return num;
        }

        int limit = (z == -1) ? n - 1 : z;

        // Try matching a prefix of length i (from left to right)
        for (int i = limit; i >= 0; i--) {
            int start = num.charAt(i) - '0' + 1;
            
            for (int d = start; d <= 9; d++) {
                int rem2 = r2 - p2[i] - f(d, 2);
                int rem3 = r3 - p3[i] - f(d, 3);
                int rem5 = r5 - p5[i] - f(d, 5);
                int rem7 = r7 - p7[i] - f(d, 7);

                int[] counts = getD(rem2, rem3, rem5, rem7);
                int req = 0;
                for (int k = 2; k <= 9; k++) req += counts[k];

                int remLen = n - 1 - i;
                if (req <= remLen) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append(d);
                    int ones = remLen - req;
                    for (int k = 0; k < ones; k++) sb.append('1');
                    for (int k = 2; k <= 9; k++) {
                        for (int j = 0; j < counts[k]; j++) {
                            sb.append(k);
                        }
                    }
                    return sb.toString();
                }
            }
        }

        // If no same-length number works, construct the smallest valid number of greater length
        int[] counts = getD(r2, r3, r5, r7);
        int req = 0;
        for (int k = 2; k <= 9; k++) req += counts[k];
        int len = Math.max(n + 1, req);

        StringBuilder sb = new StringBuilder();
        int ones = len - req;
        for (int k = 0; k < ones; k++) sb.append('1');
        for (int k = 2; k <= 9; k++) {
            for (int j = 0; j < counts[k]; j++) {
                sb.append(k);
            }
        }
        return sb.toString();
    }

    private int f(int v, int p) {
        if (v <= 0) return 0;
        int c = 0;
        while (v % p == 0) {
            c++;
            v /= p;
        }
        return c;
    }

    private int[] getD(int r2, int r3, int r5, int r7) {
        r2 = Math.max(0, r2);
        r3 = Math.max(0, r3);
        r5 = Math.max(0, r5);
        r7 = Math.max(0, r7);

        int[] d = new int[10];
        d[7] = r7;
        d[5] = r5;
        d[8] = r2 / 3;
        int m2 = r2 % 3;
        d[9] = r3 / 2;
        int m3 = r3 % 2;

        if (m2 == 1 && m3 == 0) d[2] = 1;
        else if (m2 == 2 && m3 == 0) d[4] = 1;
        else if (m2 == 0 && m3 == 1) d[3] = 1;
        else if (m2 == 1 && m3 == 1) d[6] = 1;
        else if (m2 == 2 && m3 == 1) { d[2] = 1; d[6] = 1; }

        return d;
    }
}