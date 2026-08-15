class Solution {
    public int maxDistance(int[] n1, int[] n2) {
        int i = 0;
        int j = 0;
        int m = 0;
        int l1 = n1.length;
        int l2 = n2.length;
        
        while (i < l1 && j < l2) {
            if (n1[i] <= n2[j]) {
                if (i <= j) {
                    m = Math.max(m, j - i);
                }
                j++;
            } else {
                i++;
            }
        }
        
        return m;
    }
}