class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int mi = 0, mx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[mi]) mi = i;
            if (nums[i] > nums[mx]) mx = i;
        }
        if (mi > mx) {
            int t = mi;
            mi = mx;
            mx = t;
        }
        int op1 = mx + 1;
        int op2 = n - mi;
        int op3 = (mi + 1) + (n - mx);
        return Math.min(op1, Math.min(op2, op3));
    }
}