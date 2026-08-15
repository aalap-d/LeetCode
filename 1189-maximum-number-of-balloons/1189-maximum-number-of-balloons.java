class Solution {
    public int maxNumberOfBalloons(String s) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'b') b++;
            else if (c == 'a') a++;
            else if (c == 'l') l++;
            else if (c == 'o') o++;
            else if (c == 'n') n++;
        }
        
        l /= 2;
        o /= 2;
        
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}