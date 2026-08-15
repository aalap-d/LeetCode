class Solution {
    public String removeDuplicateLetters(String s) {
        int[] f = new int[26];
        boolean[] v = new boolean[26];
        StringBuilder b = new StringBuilder();

        for (char x : s.toCharArray()) {
            f[x - 'a']++;
        }

        for (char x : s.toCharArray()) {
            f[x - 'a']--;
            if (v[x - 'a']) continue;

            while (b.length() > 0 && b.charAt(b.length() - 1) > x && f[b.charAt(b.length() - 1) - 'a'] > 0) {
                v[b.charAt(b.length() - 1) - 'a'] = false;
                b.deleteCharAt(b.length() - 1);
            }

            b.append(x);
            v[x - 'a'] = true;
        }

        return b.toString();
    }
}