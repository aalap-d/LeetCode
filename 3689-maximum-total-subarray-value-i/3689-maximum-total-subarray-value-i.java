class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int mn = nums[0];
        int mx = nums[0];
        for (int x : nums) {
            if (x < mn) mn = x;
            if (x > mx) mx = x;
        }
        return (long) (mx - mn) * k;
    }
}