import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = nums[i];
            a[i][1] = i;
        }
        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));
        
        int[] res = new int[n];
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n - 1 && a[j + 1][0] - a[j][0] <= limit) {
                j++;
            }
            
            ArrayList<Integer> idxs = new ArrayList<>();
            ArrayList<Integer> vals = new ArrayList<>();
            for (int k = i; k <= j; k++) {
                idxs.add(a[k][1]);
                vals.add(a[k][0]);
            }
            
            Collections.sort(idxs);
            
            for (int k = 0; k < idxs.size(); k++) {
                res[idxs.get(k)] = vals.get(k);
            }
            
            i = j + 1;
        }
        return res;
    }
}