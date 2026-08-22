class Solution {
    public boolean checkDivisibility(int n) {
        int s = 0;
        int p = 1;
        int t = n;
        while (t > 0) {
            int d = t % 10;
            s += d;
            p *= d;
            t /= 10;
        }
        int sum = s + p;
        return sum != 0 && n % sum == 0;
    }
}