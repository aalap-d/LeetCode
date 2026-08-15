class Solution {

    public boolean checkStrings(String first, String second) {

        int len = first.length();

        int[][] freq = new int[2][26];

        for (int i = 0; i < len; i++) {

            int pos = i % 2;  

            char ch1 = first.charAt(i);
            char ch2 = second.charAt(i);

            freq[pos][ch1 - 'a']++;

            freq[pos][ch2 - 'a']--;

        }

        for (int row = 0; row < 2; row++) {

            for (int col = 0; col < 26; col++) {

                if (freq[row][col] != 0) {
                
                    return false;
                }

              
            }
        }

    
        return true;

      
    }
}