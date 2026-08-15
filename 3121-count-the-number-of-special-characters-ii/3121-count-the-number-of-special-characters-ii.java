class Solution {
    public int numberOfSpecialChars(String word) {
        int[] l = new int[26];
        int[] u = new int[26];
        
        for (int i = 0; i < 26; i++) {
            l[i] = -1;
            u[i] = -1;
        }
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                l[c - 'a'] = i;
            } else if (c >= 'A' && c <= 'Z') {
                int idx = c - 'A';
                if (u[idx] == -1) {
                    u[idx] = i;
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (l[i] != -1 && u[i] != -1 && l[i] < u[i]) {
                ans++;
            }
        }
        
        return ans;
    }
}