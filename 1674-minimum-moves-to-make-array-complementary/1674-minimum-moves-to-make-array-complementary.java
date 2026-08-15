class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] d = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);
            
            d[2] += 2;
            d[a + 1] -= 1;
            d[a + b] -= 1;
            d[a + b + 1] += 1;
            d[b + limit + 1] += 1;
        }
        int r = n;
        int c = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            c += d[i];
            r = Math.min(r, c);
        }
        return r;
    }
}
