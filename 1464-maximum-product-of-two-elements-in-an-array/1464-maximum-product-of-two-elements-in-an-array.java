class Solution {
    public int maxProduct(int[] a) {
        int m1 = 0;
        int m2 = 0;
        for (int x : a) {
            if (x > m1) {
                m2 = m1;
                m1 = x;
            } else if (x > m2) {
                m2 = x;
            }
        }
        return (m1 - 1) * (m2 - 1);
    }
}