class Solution {
    public String findTheString(int[][] lcp) {

    int n = lcp.length;

    char[] res = new char[n];

    char currChar = 'a';

    for (int i = 0; i < n; i++) {

        if (res[i] == 0) {

            if (currChar > 'z') {
                return "";
            }

            res[i] = currChar;

            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] > 0) {
                    res[j] = currChar;
                }
            }

            currChar++;
        }
    }

    int[][] check = new int[n][n];

    for (int i = n - 1; i >= 0; i--) {

        for (int j = n - 1; j >= 0; j--) {

            if (res[i] == res[j]) {

                int next = 0;

                if (i + 1 < n && j + 1 < n) {
                    next = check[i + 1][j + 1];
                }

                check[i][j] = 1 + next;

            } else {
                check[i][j] = 0;
            }

            if (check[i][j] != lcp[i][j]) {
                return "";
            }
        }
    }

    return new String(res);
}
}