class Solution {
    public String smallestSubsequence(String s) {
        int[] f = new int[26];
        boolean[] v = new boolean[26];
        
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }
        
        StringBuilder r = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            f[c - 'a']--;
            if (v[c - 'a']) continue;
            
            while (r.length() > 0 && r.charAt(r.length() - 1) > c && f[r.charAt(r.length() - 1) - 'a'] > 0) {
                v[r.charAt(r.length() - 1) - 'a'] = false;
                r.deleteCharAt(r.length() - 1);
            }
            
            r.append(c);
            v[c - 'a'] = true;
        }
        
        return r.toString();
    }
}