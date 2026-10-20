import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> targetIndices(int[] a, int t) {
        int c = 0;
        int k = 0;
        for (int x : a) {
            if (x < t) {
                c++;
            } else if (x == t) {
                k++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(c + i);
        }
        return res;
    }
}