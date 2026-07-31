import java.util.Arrays;
class Solution {
    public int minimumPushes(String word) {
        int[] alph = new int[26];
        for (char c : word.toCharArray()) {
            alph[c - 'a']++;
        }
        Arrays.sort(alph);
        int tp = 0;
        int li = 0;
        for (int i = 25; i >= 0; i--) {
            if (alph[i] == 0) {
                break;
            }
            int pperc = (li / 8) + 1;
            tp += alph[i] * pperc;      
            li++;
        }     
        return tp;
    }
}