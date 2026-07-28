class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder leftHalf = new StringBuilder();
        char middleChar = 0;

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (freq[i] % 2 != 0) {
                middleChar = c;
            }

            for (int j = 0; j < freq[i] / 2; j++) {
                leftHalf.append(c);
            }
        }

        StringBuilder result = new StringBuilder(leftHalf);
        if (middleChar != 0) {
            result.append(middleChar);
        }
        result.append(new StringBuilder(leftHalf).reverse());

        return result.toString();
    }
}