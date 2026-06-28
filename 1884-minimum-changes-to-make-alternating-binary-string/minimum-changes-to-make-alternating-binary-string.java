class Solution {
    public int minOperations(String s) {
        int count01 = 0; 
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (i % 2 == 0) {
                if (current != '0') count01++;
            } else {
                if (current != '1') count01++;
            }
        }
        return Math.min(count01, n - count01);
    }
}
