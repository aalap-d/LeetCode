import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int curIdx = 0; 

        for (int i = 1; i <= n && curIdx < target.length; i++) {
            res.add("Push");
            
            if (target[curIdx] == i) {
                curIdx++;
            } else {
                res.add("Pop");
            }
        }
        
        return res;
    }
}