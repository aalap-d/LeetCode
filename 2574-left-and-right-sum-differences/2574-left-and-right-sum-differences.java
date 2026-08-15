public class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int l = 0;
        int r = 0;

        for (int x : nums) {
            r += x;
        }

        for (int i = 0; i < n; i++) {
            r -= nums[i];
            ans[i] = Math.abs(l - r);
            l += nums[i];
        }

        return ans;
    }
}