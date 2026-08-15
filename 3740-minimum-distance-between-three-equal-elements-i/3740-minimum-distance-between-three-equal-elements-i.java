import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            m.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int r = Integer.MAX_VALUE;
        for (List<Integer> l : m.values()) {
            int s = l.size();
            for (int i = 0; i < s - 2; i++) {
                int d = 2 * (l.get(i + 2) - l.get(i));
                if (d < r) r = d;
            }
        }
        
        return r == Integer.MAX_VALUE ? -1 : r;
    }
}