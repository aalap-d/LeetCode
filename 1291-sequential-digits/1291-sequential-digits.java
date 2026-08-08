import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int l, int h) {
        List<Integer> r = new ArrayList<>();
        String s = "123456789";
        int nl = String.valueOf(l).length();
        int nh = String.valueOf(h).length();

        for (int i = nl; i <= nh; i++) {
            for (int j = 0; j <= 9 - i; j++) {
                int v = Integer.parseInt(s.substring(j, j + i));
                if (v >= l && v <= h) {
                    r.add(v);
                }
            }
        }
        return r;
    }
}