import java.util.*;

class Solution {
    public int earliestFinishTime(int[] landStart, int[] landDur, int[] waterStart, int[] waterDur) {
        int minL = Integer.MAX_VALUE;
        for (int i = 0; i < landStart.length; i++) {
            minL = Math.min(minL, landStart[i] + landDur[i]);
        }
        
        int minW = Integer.MAX_VALUE;
        for (int j = 0; j < waterStart.length; j++) {
            minW = Math.min(minW, waterStart[j] + waterDur[j]);
        }
        
        int opt1 = Integer.MAX_VALUE;
        for (int j = 0; j < waterStart.length; j++) {
            int finish = Math.max(minL, waterStart[j]) + waterDur[j];
            opt1 = Math.min(opt1, finish);
        }
        
        int opt2 = Integer.MAX_VALUE;
        for (int i = 0; i < landStart.length; i++) {
            int finish = Math.max(minW, landStart[i]) + landDur[i];
            opt2 = Math.min(opt2, finish);
        }
        
        return Math.min(opt1, opt2);
    }
}