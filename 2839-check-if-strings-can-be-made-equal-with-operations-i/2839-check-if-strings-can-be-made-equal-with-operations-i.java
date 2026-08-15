class Solution {
    public boolean canBeEqual(String a, String b) {
        boolean e = (a.charAt(0) == b.charAt(0) && a.charAt(2) == b.charAt(2)) || 
                    (a.charAt(0) == b.charAt(2) && a.charAt(2) == b.charAt(0));
                    
        boolean o = (a.charAt(1) == b.charAt(1) && a.charAt(3) == b.charAt(3)) || 
                    (a.charAt(1) == b.charAt(3) && a.charAt(3) == b.charAt(1));
                    
        return e && o;
    }
}