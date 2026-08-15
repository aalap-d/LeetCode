class Solution {
    public int pairSum(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        ListNode p = null;
        ListNode c = s;
        while (c != null) {
            ListNode n = c.next;
            c.next = p;
            p = c;
            c = n;
        }

        int m = 0;
        ListNode h = head;
        while (p != null) {
            m = Math.max(m, h.val + p.val);
            h = h.next;
            p = p.next;
        }

        return m;
    }
}