class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = -1, miss = -1;
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] < 0) dup = val;
            else nums[val - 1] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) miss = i + 1;
        }
        return new int[]{dup, miss};
    }
}

