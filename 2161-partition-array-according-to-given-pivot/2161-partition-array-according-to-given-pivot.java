class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int idx = 0;
        for (int x : nums) {
            if (x < pivot) {
                res[idx++] = x;
            }
        }
        for (int x : nums) {
            if (x == pivot) {
                res[idx++] = x;
            }
        }
        for (int x : nums) {
            if (x > pivot) {
                res[idx++] = x;
            }
        }
        return res;
    }
}