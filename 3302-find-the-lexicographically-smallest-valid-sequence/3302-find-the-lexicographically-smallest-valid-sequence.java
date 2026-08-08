class Solution {
    public int[] validSequence(String w1, String w2) {
        int n = w1.length();
        int m = w2.length();

        int[] R = new int[m];
        for (int i = 0; i < m; i++) R[i] = -1;
        
        int j = m - 1;
        for (int i = n - 1; i >= 0 && j >= 0; i--) {
            if (w1.charAt(i) == w2.charAt(j)) {
                R[j] = i;
                j--;
            }
        }

        int[] res = new int[m];
        int p1 = 0;
        boolean usedMismatch = false;

        for (int p2 = 0; p2 < m; p2++) {
            boolean matched = false;

            while (p1 < n) {

                if (w1.charAt(p1) == w2.charAt(p2)) {
                    res[p2] = p1;
                    p1++;
                    matched = true;
                    break;
                } 

                else if (!usedMismatch && (p2 == m - 1 || (R[p2 + 1] != -1 && p1 < R[p2 + 1]))) {
                    res[p2] = p1;
                    usedMismatch = true;
                    p1++;
                    matched = true;
                    break;
                }
                
                p1++;
            }
        if (!matched) {
                return new int[0];
            }
        }

        return res;
    }
}