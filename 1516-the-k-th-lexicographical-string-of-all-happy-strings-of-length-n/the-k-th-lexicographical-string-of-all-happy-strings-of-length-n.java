import java.util.*;
class Solution 
{
    int c = 0;
    String r = "";
    public String getHappyString(int n, int k)
    {
        dfs("", n, k);
        return r;
    }
    private void dfs(String s, int n, int k) 
    {
        if (!r.equals("")) 
        return;
        if (s.length() == n) 
        {
            c++;
            if (c == k)
             r = s;
            return;
        }
        for (char i = 'a'; i <= 'c'; i++) 
        {
            if (s.length() > 0 && s.charAt(s.length() - 1) == i)
             continue;
            dfs(s + i, n, k);
        }
    }
}
