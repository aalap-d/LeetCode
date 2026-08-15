class Solution {
    public String longestCommonPrefix(String[] strs) {

    if (strs == null || strs.length == 0) {
        return "";
    }

    String prefix = strs[0];

    for (int i = 1; i < strs.length; i++) {

        String curr = strs[i];

        while (true) {

            if (curr.indexOf(prefix) == 0) {
                break;
            }

            if (prefix.length() == 0) {
                return "";
            }

            prefix = prefix.substring(0, prefix.length() - 1);
        }
    }

    return prefix;
}
}