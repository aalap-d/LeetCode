class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (sum(nums[i]) == i) {
                return i;
            }
        }
        return -1;
    }

    private int sum(int n) {
        int s = 0;
        n = Math.abs(n);
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }
}