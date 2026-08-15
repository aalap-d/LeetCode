import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        int prevTime = 0;
        
        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);
            
            if (type.equals("start")) {
                if (!st.isEmpty()) {
                    res[st.peek()] += time - prevTime;
                }
                st.push(id);
                prevTime = time;
            } else {
                res[st.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        
        return res;
    }
}