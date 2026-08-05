import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] inv : invocations) {
            g.get(inv[0]).add(inv[1]);
        }

        boolean[] sus = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        sus[k] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            count++;
            for (int v : g.get(u)) {
                if (!sus[v]) {
                    sus[v] = true;
                    q.add(v);
                }
            }
        }

        for (int[] inv : invocations) {
            if (!sus[inv[0]] && sus[inv[1]]) {
                List<Integer> res = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    res.add(i);
                }
                return res;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!sus[i]) {
                res.add(i);
            }
        }
        return res;
    }
}