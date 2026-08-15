import java.util.*;

class Solution {
    public List<String> twoEditWords(String[] q, String[] d) {
        List<String> r = new ArrayList<>();
        
        for (String x : q) {
            for (String y : d) {
                int c = 0;
                
                for (int i = 0; i < x.length(); i++) {
                    if (x.charAt(i) != y.charAt(i)) {
                        c++;
                    }
                }
                
                if (c <= 2) {
                    r.add(x);
                    break;
                }
            }
        }
        
        return r;
    }
}