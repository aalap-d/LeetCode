import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(a);

        long s = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            s += a[r--];
            if (l <= r) {
                s -= a[l++];
            }
        }
        return s;
    }
}