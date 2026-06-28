class Solution {
    public int furthestDistanceFromOrigin(String m) {
        int d = 0;
        int u = 0;
        for (char c : m.toCharArray()) {
            if (c == 'L') {
                d--;
            } else if (c == 'R') {
                d++;
            } else {
                u++;
            }
        }
        return Math.abs(d) + u;
    }
}