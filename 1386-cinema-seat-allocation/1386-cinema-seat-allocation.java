import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map to store the bitmask of reserved seats for each row that has at least one reservation
        Map<Integer, Integer> rowMasks = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            // Set the bit corresponding to the seat number to 1
            rowMasks.put(row, rowMasks.getOrDefault(row, 0) | (1 << col));
        }
        
        // If a row has no reservations, it can fit exactly 2 groups.
        // We start by assuming all rows are empty.
        int maxGroups = 2 * n;
        
        // Deduct 2 for every row that has at least one reservation, 
        // then add back the actual number of groups that can fit.
        maxGroups -= 2 * rowMasks.size();
        
        for (int mask : rowMasks.values()) {
            boolean leftFree = (mask & 60) == 0;   
            boolean rightFree = (mask & 960) == 0; 
            boolean midFree = (mask & 240) == 0;   
            
            // Check if we can fit 2 groups (no overlap between left and right)
            if (leftFree && rightFree) {
                maxGroups += 2;
            } 
            // Check if we can fit at least 1 group in any valid block
            else if (leftFree || rightFree || midFree) {
                maxGroups += 1;
            }
        }
        
        return maxGroups;
    }
}