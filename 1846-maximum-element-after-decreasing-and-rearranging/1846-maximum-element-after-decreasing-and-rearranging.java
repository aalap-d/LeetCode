import java.util.Arrays;
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        int l = arr.length;
        
        for (int i = 1; i < l; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        
        return arr[l - 1];
    }
}