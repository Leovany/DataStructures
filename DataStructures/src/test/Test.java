package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Node root = new Node(1);
        NodeTree tree = new NodeTree(root);
        tree.generate(5);
        System.out.println(tree);

        Node node_1 = tree.search(20);
        Node node_2 = tree.search(3);
        System.out.println(node_1);
        System.out.println(node_2);

        String nodePath = tree.findNodePath(node_2, node_1);
        System.out.println(nodePath);

    }
}

/**
 * 定义二叉树
 */
class NodeTree {
    private Node root = null;

    public NodeTree(Node root) {
        this.root = root;
    }

    /**
     * 生成满二叉树
     */
    public void generate(int level) {
        if (root == null) {
            return;
        }
        root.generate(level);
    }

    /**
     * 查找
     *
     * @param val
     * @return
     */
    public Node search(int val) {
        if (root == null) {
            return null;
        }
        return root.preOrderSearch(val);
    }

    public String findNodePath(Node node_1, Node node_2) {
        // 1. 找到最近根祖先
        Node lastCommonAncestor = findLastCommonAncestor(root, node_1, node_2);
        System.out.println(lastCommonAncestor);
        // 2. 查找路径
        List<Integer> nodePath_1 = findPath(lastCommonAncestor, node_1);
//        System.out.println(node_1);
        List<Integer> nodePath_2 = findPath(lastCommonAncestor, node_2);
        // 3. 合并路径
        List<Integer> allPathList = new ArrayList<>();
        allPathList.addAll(nodePath_1);
        allPathList.add(lastCommonAncestor.val);
        allPathList.addAll(nodePath_2);
        System.out.println(allPathList);
        // 3. 输出路径
        List<String> collect = allPathList.stream().map(String::valueOf).collect(Collectors.toList());
        return String.join("->", collect);
    }

    private List<Integer> findPath(Node root, Node node) {
        ArrayList<Integer> list = new ArrayList<>();

        Node temp = node;
        do {
            list.add(temp.val);
            temp = temp.parent;
        } while (temp.val != root.val);

        return list;

    }

    public Node findLastCommonAncestor(Node root, Node node_1, Node node_2) {
        if (root == null) {
            return null;
        }
        if (root.val == node_1.val || root.val == node_2.val) {
            return root;
        }
        // 找左边
        Node left = findLastCommonAncestor(root.left, node_1, node_2);
        // 找右边
        Node right = findLastCommonAncestor(root.right, node_1, node_2);
        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;


    }


}

/**
 * 定义节点
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" + "val=" + val + '}';
    }

    /**
     * 生成满二叉树
     */
    public void generate(int level) {
        if (level == 1) {
            return;
        }
        Node left = new Node(this.val * 2);
        this.left = left;
        left.parent = this;
        left.generate(level - 1);

        Node right = new Node(this.val * 2 + 1);
        this.right = right;
        right.parent = this;
        right.generate(level - 1);

    }

    /**
     * 前序查找，根左右
     *
     * @return
     */
    public Node preOrderSearch(int val) {
        // 根
        if (this.val == val) {
            return this;
        }
        // 左
        Node resultNode = null;
        if (this.left != null) {
            resultNode = this.left.preOrderSearch(val);
        }
        if (resultNode != null) {
            return resultNode;
        }
        // 右
        if (this.right != null) {
            resultNode = this.right.preOrderSearch(val);
        }
        return resultNode;


    }

}
