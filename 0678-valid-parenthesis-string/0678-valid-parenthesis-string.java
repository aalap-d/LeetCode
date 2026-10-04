class Solution {
    public boolean checkValidString(String s) {
        int lo = 0;
        int hi = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                lo++;
                hi++;
            } else if (c == ')') {
                lo--;
                hi--;
            } else {
                lo--;
                hi++;
            }

            if (hi < 0) {
                return false;
            }

            if (lo < 0) {
                lo = 0;
            }
        }

        return lo == 0;
    }
}