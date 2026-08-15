import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int[] minDists = new int[n];

        for (List<Integer> indices : indexMap.values()) {
            int size = indices.size();
            if (size == 1) {
                minDists[indices.get(0)] = -1;
            } else {
                for (int i = 0; i < size; i++) {
                    int current = indices.get(i);

                    int prev = indices.get((i - 1 + size) % size);

                    int next = indices.get((i + 1) % size);

                    int dist1 = Math.abs(current - prev);
                    dist1 = Math.min(dist1, n - dist1);
    
                    int dist2 = Math.abs(current - next);
                    dist2 = Math.min(dist2, n - dist2);

                    minDists[current] = Math.min(dist1, dist2);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            result.add(minDists[q]);
        }
        
        return result;
    }
}