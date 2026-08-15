import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> m = new HashMap<>();
        Set<Integer> c = new HashSet<>();

        for (int[] d : descriptions) {
            int pVal = d[0];
            int cVal = d[1];
            int isLeft = d[2];

            m.putIfAbsent(pVal, new TreeNode(pVal));
            m.putIfAbsent(cVal, new TreeNode(cVal));

            TreeNode pNode = m.get(pVal);
            TreeNode cNode = m.get(cVal);

            if (isLeft == 1) {
                pNode.left = cNode;
            } else {
                pNode.right = cNode;
            }

            c.add(cVal);
        }

        for (int pVal : m.keySet()) {
            if (!c.contains(pVal)) {
                return m.get(pVal);
            }
        }

        return null;
    }
}