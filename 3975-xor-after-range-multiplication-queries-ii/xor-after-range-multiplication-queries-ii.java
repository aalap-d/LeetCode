import java.util.*;

class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int MOD = 1000000007;

        int B = (int) Math.sqrt(n);
        if (B < 1) B = 1;
        
        List<List<int[]>> groupedQueries = new ArrayList<>();
        for (int i = 0; i <= B; i++) {
            groupedQueries.add(new ArrayList<>());
        }
        
        for (int[] q : queries) {
            int k = q[2];
            if (k <= B) {
                groupedQueries.get(k).add(q);
            } else {

                long v = q[3];
                for (int i = q[0]; i <= q[1]; i += k) {
                    nums[i] = (int) ((nums[i] * v) % MOD);
                }
            }
        }

        int[] diff = new int[n];
        for (int k = 1; k <= B; k++) {
            List<int[]> group = groupedQueries.get(k);
            if (group.isEmpty()) continue;
            
            Arrays.fill(diff, 1); 
            
            for (int[] q : group) {
                int l = q[0], r = q[1], v = q[3];

                diff[l] = (int) ((diff[l] * (long) v) % MOD);
                
                int steps = (r - l) / k;
                int nextIdx = l + steps * k + k;
                
                if (nextIdx < n) {
 
                    long invV = power(v, MOD - 2, MOD);
                    diff[nextIdx] = (int) ((diff[nextIdx] * invV) % MOD);
                }
            }
            
            for (int i = k; i < n; i++) {
                diff[i] = (int) ((diff[i] * (long) diff[i - k]) % MOD);
            }
            
    
            for (int i = 0; i < n; i++) {
                if (diff[i] != 1) {
                    nums[i] = (int) ((nums[i] * (long) diff[i]) % MOD);
                }
            }
        }

        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        
        return xorSum;
    }
    
 
    private long power(long base, long exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}