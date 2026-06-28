class Solution {
    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {
        int n = ls.length;
        int m = ws.length;
        
        int mle = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            mle = Math.min(mle, ls[i] + ld[i]);
        }
        
        int mwe = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mwe = Math.min(mwe, ws[j] + wd[j]);
        }
        
        int ans = Integer.MAX_VALUE;
        
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, Math.max(mle, ws[j]) + wd[j]);
        }
        
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, Math.max(mwe, ls[i]) + ld[i]);
        }
        
        return ans;
    }
}
