import java.util.*;

class Solution {
    public int firstUniqueEven(int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : a) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        for (int x : a) {
            if (x % 2 == 0 && m.get(x) == 1) {
                return x;
            }
        }
        return -1;
    }
}