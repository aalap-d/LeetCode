class Solution {
    public int missingMultiple(int[] nums, int k) {
        java.util.HashSet<Integer> s = new java.util.HashSet<>();
        for (int x : nums) {
            if (x % k == 0) {
                s.add(x);
            }
        }
        
        int m = k;
        while (s.contains(m)) {
            m += k;
        }
        
        return m;
    }
}