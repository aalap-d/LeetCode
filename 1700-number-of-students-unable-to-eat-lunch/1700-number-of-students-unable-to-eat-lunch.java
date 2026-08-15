import java.util.*;

public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] counts = new int[2];
        for (int s : students) {
            counts[s]++;
        }

        for (int s : sandwiches) {
            if (counts[s] > 0) {
                counts[s]--;
            } else {
                return counts[0] + counts[1];
            }
        }

        return 0;
    }
}