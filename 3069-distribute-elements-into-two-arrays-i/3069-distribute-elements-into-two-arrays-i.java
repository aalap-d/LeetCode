class Solution {
    public int[] resultArray(int[] n) {
        int s = n.length;
        int[] a1 = new int[s];
        int[] a2 = new int[s];
        int c1 = 0, c2 = 0;
        
        a1[c1++] = n[0];
        if (s > 1) {
            a2[c2++] = n[1];
        }
        
        for (int i = 2; i < s; i++) {
            if (a1[c1 - 1] > a2[c2 - 1]) {
                a1[c1++] = n[i];
            } else {
                a2[c2++] = n[i];
            }
        }
        
        int[] r = new int[s];
        int p = 0;
        
        for (int i = 0; i < c1; i++) {
            r[p++] = a1[i];
        }
        for (int i = 0; i < c2; i++) {
            r[p++] = a2[i];
        }
        
        return r;
    }
}