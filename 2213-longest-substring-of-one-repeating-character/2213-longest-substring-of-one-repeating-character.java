class N {
    int mx, p, s, l;
    char pc, sc;
    N(int m, int pf, int sf, int ln, char c1, char c2) {
        mx = m; p = pf; s = sf; l = ln; pc = c1; sc = c2;
    }
}

class Solution {
    N[] t;

    void b(char[] a, int x, int l, int r) {
        if(l == r) {
            t[x] = new N(1, 1, 1, 1, a[l], a[l]);
            return;
        }
        int m = l + (r - l) / 2;
        b(a, 2 * x, l, m);
        b(a, 2 * x + 1, m + 1, r);
        t[x] = mg(t[2 * x], t[2 * x + 1]);
    }

    void u(int x, int l, int r, int i, char c) {
        if(l == r) {
            t[x] = new N(1, 1, 1, 1, c, c);
            return;
        }
        int m = l + (r - l) / 2;
        if(i <= m) {
            u(2 * x, l, m, i, c);
        } else {
            u(2 * x + 1, m + 1, r, i, c);
        }
        t[x] = mg(t[2 * x], t[2 * x + 1]);
    }

    N mg(N l, N r) {
        int pf = l.p;
        if (l.p == l.l && l.sc == r.pc) pf += r.p;
        
        int sf = r.s;
        if (r.s == r.l && r.pc == l.sc) sf += l.s;
        
        int mx = Math.max(l.mx, r.mx);
        if (l.sc == r.pc) mx = Math.max(mx, l.s + r.p);
        
        return new N(mx, pf, sf, l.l + r.l, l.pc, r.sc);
    }

    public int[] longestRepeating(String s, String qc, int[] qi) {
        int n = s.length();
        int k = qi.length;
        char[] a = s.toCharArray();
        t = new N[4 * n + 1];
        b(a, 1, 0, n - 1);
        
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            u(1, 0, n - 1, qi[i], qc.charAt(i));
            ans[i] = t[1].mx;
        }
        return ans;
    }
}