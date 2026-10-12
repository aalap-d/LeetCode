import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] c = new int[32];
        for (int x : nums) {
            for (int i = 0; i < 32; i++) {
                if (((x >> i) & 1) == 1) {
                    c[i]++;
                }
            }
        }
        
        long ans = 0;
        long m = 1_000_000_007L;
        
        for (int j = 0; j < k; j++) {
            long cur = 0;
            for (int i = 0; i < 32; i++) {
                if (c[i] > 0) {
                    cur |= (1L << i);
                    c[i]--;
                }
            }
            ans = (ans + (cur % m) * (cur % m)) % m;
        }
        
        return (int) ans;
    }
}