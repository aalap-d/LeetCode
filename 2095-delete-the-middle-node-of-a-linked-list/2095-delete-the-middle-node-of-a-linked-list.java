class Solution {
    public ListNode deleteMiddle(ListNode h) {
        if (h == null || h.next == null) {
            return null;
        }
        
        ListNode s = h;
        ListNode f = h;
        ListNode p = null;
        
        while (f != null && f.next != null) {
            p = s;
            s = s.next;
            f = f.next.next;
        }
        
        p.next = s.next;
        
        return h;
    }
}