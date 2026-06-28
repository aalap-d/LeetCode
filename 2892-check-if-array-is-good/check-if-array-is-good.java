import java.util.*;

class Solution {
    public boolean isGood(int[] nums) {
        int l = nums.length;
        if (l < 2) return false;
        int n = l - 1;
        int[] c = new int[n + 1];
        for (int x : nums) {
            if (x < 1 || x > n) return false;
            c[x]++;
        }
        for (int i = 1; i < n; i++) {
            if (c[i] != 1) return false;
        }
        return c[n] == 2;
    }
}