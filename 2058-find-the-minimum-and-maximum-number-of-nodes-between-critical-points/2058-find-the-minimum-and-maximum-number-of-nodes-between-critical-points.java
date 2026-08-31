class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode h) {
        if (h == null || h.next == null || h.next.next == null) {
            return new int[]{-1, -1};
        }
        int mn = Integer.MAX_VALUE;
        int mx = -1;
        int f = -1;
        int p = -1;
        int i = 1;
        ListNode prev = h;
        ListNode curr = h.next;
        while (curr.next != null) {
            int v = curr.val;
            int pv = prev.val;
            int nv = curr.next.val;
            if ((v > pv && v > nv) || (v < pv && v < nv)) {
                if (f == -1) {
                    f = i;
                } else {
                    mn = Math.min(mn, i - p);
                    mx = i - f;
                }
                p = i;
            }
            prev = curr;
            curr = curr.next;
            i++;
        }
        if (mx == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{mn, mx};
    }
}