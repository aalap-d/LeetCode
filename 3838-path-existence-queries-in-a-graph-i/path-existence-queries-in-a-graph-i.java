class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] component = new int[n];
        
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                component[i] = component[i - 1];
            } else {
                component[i] = component[i - 1] + 1;
            }
        }
        
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {

            answer[i] = component[queries[i][0]] == component[queries[i][1]];
        }
        
        return answer;
    }
}