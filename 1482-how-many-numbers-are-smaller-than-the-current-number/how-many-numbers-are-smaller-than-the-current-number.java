import java.util.*;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] s = nums.clone();
        Arrays.sort(s);
        
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            // Only put if not present to handle duplicates (keep the smallest index)
            m.putIfAbsent(s[i], i);
        }
        
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = m.get(nums[i]);
        }
        return res;
    }
}