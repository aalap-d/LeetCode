class Solution {
    public double angleClock(int h, int m) {
        double ha = (h % 12) * 30 + m * 0.5;
        double ma = m * 6;
        double d = Math.abs(ha - ma);
        return Math.min(d, 360 - d);
    }
}