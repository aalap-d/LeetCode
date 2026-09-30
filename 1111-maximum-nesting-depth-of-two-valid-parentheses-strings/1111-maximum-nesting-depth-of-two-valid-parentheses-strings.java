class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        int d = 0;

        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                res[i] = d % 2;
                d++;
            } else {
                d--;
                res[i] = d % 2;
            }
        }
        return res;
    }
}