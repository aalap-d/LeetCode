class Solution {
    public int findGCD(int[] n) {
        int mn = n[0];
        int mx = n[0];
        
        for (int i = 1; i < n.length; i++) {
            if (n[i] < mn) mn = n[i];
            if (n[i] > mx) mx = n[i];
        }
        
        return g(mn, mx);
    }
    
    private int g(int a, int b) {
        if (b == 0) return a;
        return g(b, a % b);
    }
}