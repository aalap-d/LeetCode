class Solution {
    public int maximumProduct(int[] a) {
        int mx1 = Integer.MIN_VALUE, mx2 = Integer.MIN_VALUE, mx3 = Integer.MIN_VALUE;
        int mn1 = Integer.MAX_VALUE, mn2 = Integer.MAX_VALUE;

        for (int x : a) {
            if (x > mx1) {
                mx3 = mx2;
                mx2 = mx1;
                mx1 = x;
            } 
            else if (x > mx2) {
                mx3 = mx2;
                mx2 = x;
            } 
            else if (x > mx3) {
                mx3 = x;
            }

            if (x < mn1) {
                mn2 = mn1;
                mn1 = x;
            } 
            else if (x < mn2) {
                mn2 = x;
            }
        }

        return Math.max(mx1 * mx2 * mx3, mn1 * mn2 * mx1);
    }
}
