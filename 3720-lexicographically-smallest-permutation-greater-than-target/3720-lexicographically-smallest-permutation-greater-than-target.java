class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        char[] ca = s.toCharArray();
        java.util.Arrays.sort(ca);
        
        int[] count = new int[26];
        for (char c : ca) {
            count[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        if (dfs(n, count, target, sb, 0, false)) {
            return sb.toString();
        }
        return "";
    }
    
    private boolean dfs(int n, int[] count, String target, StringBuilder sb, int idx, boolean isGreater) {
        if (idx == n) {
            return isGreater;
        }
        if (!isGreater) {

        }
        
        int start = isGreater ? 0 : (target.charAt(idx) - 'a');

        for (int c = 0; c < 26; c++) {
            if (count[c] == 0) continue;
            
            if (!isGreater && c < (target.charAt(idx) - 'a')) {
                continue;
            }

            count[c]--;
            sb.append((char)('a' + c));
            
            boolean nextIsGreater = isGreater || (c > (target.charAt(idx) - 'a'));

            if (isValid(n, count, target, sb, idx + 1, nextIsGreater)) {
                if (dfs(n, count, target, sb, idx + 1, nextIsGreater)) {
                    return true;
                }
            }
            
            sb.deleteCharAt(sb.length() - 1);
            count[c]++;
        }
        
        return false;
    }
    
    private boolean isValid(int n, int[] count, String target, StringBuilder sb, int nextIdx, boolean isGreater) {
        if (isGreater) return true;

        int[] remCount = count.clone();
        char[] smallestRemaining = new char[n - nextIdx];
        int p = 0;
        for (int c = 0; c < 26; c++) {
            for (int i = 0; i < remCount[c]; i++) {
                smallestRemaining[p++] = (char)('a' + c);
            }
        }
        return true;
    }
}