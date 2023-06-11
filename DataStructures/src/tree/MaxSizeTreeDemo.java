package tree;

/**
 * 二叉树最大路径和
 */
public class MaxSizeTreeDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.generate(3);

        int sum = maxPathSum(root);
        System.out.println(sum);
    }

    static int pathSum = Integer.MIN_VALUE;

    /**
     * 最大路径和
     *
     * @param treeNode
     * @return
     */
    public static int maxPathSum(TreeNode treeNode) {
        dfs(treeNode);
        return pathSum;
    }

    private static int dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int leftPathSum = dfs(treeNode.left);
        int rightPahtSum = dfs(treeNode.right);
        // 子树和
        int ret = Math.max(treeNode.val, Math.max(treeNode.val + leftPathSum, treeNode.val + rightPahtSum));

        pathSum = Math.max(pathSum, Math.max(ret, treeNode.val + leftPathSum + rightPahtSum));
        return ret;
    }

}

