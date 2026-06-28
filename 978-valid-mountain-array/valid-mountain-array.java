class Solution {
    public boolean validMountainArray(int[] a) {
        int l = a.length;
        
        if (l < 3) {
            return false;
        }
        
        int i = 0;
        
        while (i + 1 < l && a[i] < a[i + 1]) {
            i++;
        }
        
        if (i == 0 || i == l - 1) {
            return false;
        }
        
        while (i + 1 < l && a[i] > a[i + 1]) {
            i++;
        }
        
        return i == l - 1;
    }
}