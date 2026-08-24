class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] s = new int[n];
        s[0] = stones[0];
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + stones[i];
        }
        
        int ans = s[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            ans = Math.max(ans, s[i] - ans);
        }
        
        return ans;
    }
}