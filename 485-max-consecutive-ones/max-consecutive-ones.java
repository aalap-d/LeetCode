class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int x : nums) {
            if (x == 1) {
                cur++;
                if (cur > max) max = cur;
            } else {
                cur = 0;
            }
        }
        return max;
    }
}
