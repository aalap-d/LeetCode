class Solution                                              {
    public int numOfStrings(String[] patterns, String word) {
        int c = 0;
        for (int i = 0; i < patterns.length; i++)           {
            if (word.contains(patterns[i]))
                c += 1;                                     }
        return c;                                           }
                                                            }