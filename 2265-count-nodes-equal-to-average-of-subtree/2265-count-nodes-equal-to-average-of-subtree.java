class Solution {
    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] l = dfs(node.left);
        int[] r = dfs(node.right);

        int s = l[0] + r[0] + node.val;
        int c = l[1] + r[1] + 1;

        if (node.val == s / c) {
            ans++;
        }

        return new int[]{s, c};
    }
}