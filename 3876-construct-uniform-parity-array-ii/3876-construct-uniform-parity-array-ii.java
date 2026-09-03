class Solution {
    public boolean uniformArray(int[] nums1) {
        int mn = Integer.MAX_VALUE;
        for (int x : nums1) {
            if (x % 2 != 0) {
                mn = Math.min(mn, x);
            }
        }
        for (int x : nums1) {
            if (x % 2 == 0 && mn != Integer.MAX_VALUE && x < mn) {
                return false;
            }
        }
        return true;
    }
}