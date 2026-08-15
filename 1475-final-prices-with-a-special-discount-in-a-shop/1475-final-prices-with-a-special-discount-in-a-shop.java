import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        System.arraycopy(prices, 0, res, 0, n);
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                int idx = st.pop();
                res[idx] -= prices[i];
            }
            st.push(i);
        }
        
        return res;
    }
}