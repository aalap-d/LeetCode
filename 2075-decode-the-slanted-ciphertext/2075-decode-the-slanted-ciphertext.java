class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        if (len == 0) return "";
        
        int cols = len / rows;
        StringBuilder sb = new StringBuilder();
        
        for (int k = 0; k < cols; k++) {
            for (int r = 0; r < rows; r++) {
                int c = k + r;
                if (c < cols) {
                    sb.append(encodedText.charAt(r * cols + c));
                } else {
                    break;
                }
            }
        }
        int i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) == ' ') {
            i--;
        }
        
        return sb.substring(0, i + 1);
    }
}