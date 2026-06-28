class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;
        
        for (int[] q : queries) {
            int idx = q[0];
            while (idx <= q[1]) {
                nums[idx] = (int) ((nums[idx] * (long) q[3]) % MOD);
                idx += q[2];
            }
        }
        
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        
        return xorSum;
    }
}