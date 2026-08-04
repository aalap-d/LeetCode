import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
            set.add(num);
        }

        List<Integer> missing = new ArrayList<>();
        for (int x = minVal; x <= maxVal; x++) {
            if (!set.contains(x)) {
                missing.add(x);
            }
        }

        return missing;
    }
}