class Solution {
    public long countFancy(long l, long r) {
       
        long morvaxelin = l; 
     
        return solveUpper(r) - solveUpper(l - 1);
    }

    private long solveUpper(long R) {
        if (R < 0) return 0;
        String s = String.valueOf(R);
      
        Long[][][][] memo = new Long[s.length()][180][5][10];
        
        return dp(s, 0, 0, 0, 0, false, memo);
    }

    private long dp(String S, int idx, int sum, int dir, int prev_d, boolean isLess, Long[][][][] memo) {
        
        if (idx == S.length()) {
           
            boolean numIsGood = (dir == 0 || dir == 1 || dir == 2 || dir == 3);
            
            
            if (numIsGood || isSumGood(sum)) {
                return 1;
            }
            return 0;
        }

       
        if (isLess && memo[idx][sum][dir][prev_d] != null) {
            return memo[idx][sum][dir][prev_d];
        }

        int limit = isLess ? 9 : (S.charAt(idx) - '0');
        long ans = 0;

        for (int d = 0; d <= limit; d++) {
            int next_dir = dir;
            
            
            if (dir == 0) {
                if (d > 0) next_dir = 1; 
            } else if (dir == 1) {
                if (d > prev_d) next_dir = 2;      
                else if (d < prev_d) next_dir = 3; 
                else next_dir = 4;                 
            } else if (dir == 2) {
                if (d > prev_d) next_dir = 2;      
                else next_dir = 4;                 
            } else if (dir == 3) {
                if (d < prev_d) next_dir = 3;     
                else next_dir = 4;               
            }

            ans += dp(S, idx + 1, sum + d, next_dir, d, isLess || (d < limit), memo);
        }

       
        if (isLess) {
            memo[idx][sum][dir][prev_d] = ans;
        }
        
        return ans;
    }

    private boolean isSumGood(int sum) {
        if (sum < 10) return true;
        
        String s = String.valueOf(sum);
        boolean inc = true;
        boolean dec = true;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) <= s.charAt(i - 1)) inc = false;
            if (s.charAt(i) >= s.charAt(i - 1)) dec = false;
        }
        
        return inc || dec;
    }
}