import java.util.*;
public class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 1;
        long maxW = 0;
        for (int w : workerTimes) {
            maxW = Math.max(maxW, (long) w);
        }

        long high = maxW * mountainHeight * (mountainHeight + 1L) / 2;
        long result = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canReduce(mountainHeight, workerTimes, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean canReduce(int targetHeight, int[] workerTimes, long timeLimit) {
        long totalReduction = 0;
        for (int w : workerTimes) {
            long x = (long) ((-1 + Math.sqrt(1 + 8.0 * (double) timeLimit / w)) / 2);
            totalReduction += x;
            if (totalReduction >= targetHeight) {
                return true;
            }
        }
        return totalReduction >= targetHeight;
    }
}