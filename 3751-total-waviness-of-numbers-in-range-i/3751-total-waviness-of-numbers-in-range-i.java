public class Solution {
    // Changed return type from long to int
    public int totalWaviness(int num1, int num2) {
        int sum = 0; // Changed from long to int
        for (int i = num1; i <= num2; i++) {
            sum += getWaviness(i);
        }
        return sum;
    }

    private int getWaviness(int n) {
        String s = Integer.toString(n);
        int len = s.length();
        if (len < 3) {
            return 0;
        }
        int cnt = 0;
        for (int i = 1; i < len - 1; i++) {
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);
            if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                cnt++;
            }
        }
        return cnt;
    }
}