import java.util.*;

public class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        int low = 0;
        int high = 0;
        int mandatoryCount = 0;
        for (int[] e : edges) {
            high = Math.max(high, e[2] * 2);
            if (e[3] == 1) mandatoryCount++;
        }

        if (mandatoryCount >= n) return -1;

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isValid(int n, int[][] edges, int k, int X) {
        DSU dsu = new DSU(n);
        int edgesUsed = 0;
        int upgradesUsed = 0;

        for (int[] e : edges) {
            if (e[3] == 1) {
                if (e[2] < X) return false;
                if (!dsu.union(e[0], e[1])) return false;
                edgesUsed++;
            }
        }

        for (int[] e : edges) {
            if (e[3] == 0 && e[2] >= X) {
                if (dsu.union(e[0], e[1])) {
                    edgesUsed++;
                }
            }
        }

        for (int[] e : edges) {
            if (e[3] == 0 && e[2] < X && e[2] * 2 >= X) {
                if (upgradesUsed < k) {
                    if (dsu.union(e[0], e[1])) {
                        edgesUsed++;
                        upgradesUsed++;
                    }
                }
            }
        }

        return edgesUsed == n - 1;
    }

    class DSU {
        int[] parent;
        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                return true;
            }
            return false;
        }
    }
}