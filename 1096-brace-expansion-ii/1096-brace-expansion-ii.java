import java.util.*;

class Solution {
    int idx = 0;

    public List<String> braceExpansionII(String s) {
        idx = 0;
        Set<String> res = parseE(s);
        List<String> list = new ArrayList<>(res);
        Collections.sort(list);
        return list;
    }

    private Set<String> parseE(String s) {
        Set<String> res = new HashSet<>();
        while (idx < s.length() && s.charAt(idx) != '}') {
            Set<String> cur = parseT(s);
            res.addAll(cur);
            if (idx < s.length() && s.charAt(idx) == ',') {
                idx++;
            }
        }
        return res;
    }

    private Set<String> parseT(String s) {
        Set<String> res = new HashSet<>();
        res.add("");
        while (idx < s.length() && s.charAt(idx) != '}' && s.charAt(idx) != ',') {
            Set<String> cur = parseF(s);
            Set<String> next = new HashSet<>();
            for (String a : res) {
                for (String b : cur) {
                    next.add(a + b);
                }
            }
            res = next;
        }
        return res;
    }

    private Set<String> parseF(String s) {
        Set<String> res = new HashSet<>();
        if (s.charAt(idx) == '{') {
            idx++;
            res = parseE(s);
            idx++;
        } else {
            res.add(String.valueOf(s.charAt(idx++)));
        }
        return res;
    }
}