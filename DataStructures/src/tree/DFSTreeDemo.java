package tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 257题: 二叉树的所有路径——dfs算法
 */
public class DFSTreeDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.generate(3);
        List<String> paths = binaryTreePaths(root);
        System.out.println(paths);
    }

    public static  List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ans = new ArrayList<>();
        dfs(root, "", ans);
        return ans;
    }

    private static  void dfs(TreeNode node, String path, List<String> ans) {
        if (node == null) {
            return;
        }

        StringBuilder sb = new StringBuilder(path);
        sb.append(node.val + "");

        if (node.left == null && node.right == null) {
            // 叶节点，添加路径
            ans.add(sb.toString());
        } else {
            sb.append("->");
            dfs(node.left, sb.toString(), ans);
            dfs(node.right, sb.toString(), ans);
        }
    }

}


class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" + "val=" + val + '}';
    }

    /**
     * 生成满二叉树
     *
     * @param level
     */
    public void generate(int level) {
        if (level == 1) {
            return;
        }
        TreeNode leftNode = new TreeNode(val * 2);
        this.left = leftNode;
        leftNode.generate(level - 1);

        TreeNode rightNode = new TreeNode(val * 2 + 1);
        this.right = rightNode;
        rightNode.generate(level - 1);


    }

}