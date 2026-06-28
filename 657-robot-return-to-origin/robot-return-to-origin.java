class Solution                                   {
    public boolean judgeCircle(String m)         {
        int x = 0;
        int y = 0;
        int l = m.length();
        
        for (int i = 0; i < l; i++)              {
            char c = m.charAt(i);
            if (c == 'R')                        {
                x++;
                                                 } 
            else if (c == 'L')                   {
                x--;
                                                 }
             else if (c == 'U')
                                                 {
                y++;
                                                 } 
            else if (c == 'D')
                                                 {
                y--;
                                                 }
                                                 }
        
        return x == 0 && y == 0;
                                                 }
                                                 }