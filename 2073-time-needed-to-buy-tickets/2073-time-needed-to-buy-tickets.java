import java.util.*;

public class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int t = 0;
        int goal = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                t += Math.min(tickets[i], goal);
            } else {
                t += Math.min(tickets[i], goal - 1);
            }
        }
        return t;
    }
}