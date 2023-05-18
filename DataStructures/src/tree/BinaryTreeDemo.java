package tree;

/**
 * 二叉树遍历和查找
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        Node root = new Node(1);

        Node node_2 = new Node(2);
        Node node_3 = new Node(3);
        Node node_5 = new Node(5);
        Node node_4 = new Node(4);

        root.left = node_2;
        root.right = node_3;

        node_3.left = node_5;
        node_3.right = node_4;

        NodeTree nodeTree = new NodeTree(root);

        System.out.println("前序遍历");
        nodeTree.preOrder();
        System.out.println("中序遍历");
        nodeTree.infexOrder();
        System.out.println("后序遍历");
        nodeTree.postOrder();

        System.out.println("前序查找 = " + nodeTree.preOrderSearch(5));
        System.out.println("中序查找 = " + nodeTree.infixOrderSearch(5));
        System.out.println("后序查找 = " + nodeTree.postOrderSearch(5));
    }
}

class NodeTree {
    private Node root = null;

    public NodeTree(Node node) {
        this.root = node;
    }

    public void preOrder() {
        if (root == null) {
            System.out.println("根节点为空");
            return;
        }
        root.preOrder();
    }


    public void infexOrder() {
        if (root == null) {
            System.out.println("根节点为空");
            return;
        }
        root.infixOrder();
    }

    public void postOrder() {
        if (root == null) {
            System.out.println("根节点为空");
            return;
        }
        root.postOrder();
    }

    public Node preOrderSearch(int no) {
        if (root == null) {
            return null;
        }
        return root.preOrderSearch(no);
    }

    public Node infixOrderSearch(int no) {
        if (root == null) {
            return null;
        }
        return root.infixOrderSearch(no);
    }

    public Node postOrderSearch(int no) {
        if (root == null) {
            return null;
        }
        return root.postOrderSearch(no);
    }

}

class Node {

    public int no;
    public Node left;
    public Node right;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" + "no=" + no + '}';
    }

    /**
     * 前序遍历，根左右
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历，左根右
     */
    public void infixOrder() {

        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历，左右跟
     */
    public void postOrder() {

        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序查找，根左右
     *
     * @param no
     */
    public Node preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        // 左
        Node resultNode = null;
        if (this.left != null) {
            resultNode = this.left.preOrderSearch(no);
        }
        if (resultNode != null) {
            return resultNode;
        }
        // 右
        if (this.right != null) {
            resultNode = this.right.preOrderSearch(no);
        }
        return resultNode;
    }

    /**
     * 中序查找，左根右
     *
     * @param no
     * @return
     */
    public Node infixOrderSearch(int no) {
        // 左
        Node resultNode = null;
        if (this.left != null) {
            resultNode = this.left.infixOrderSearch(no);
        }
        if (resultNode != null) {
            return resultNode;
        }
        // 根
        if (this.no == no) {
            return this;
        }

        // 右
        if (this.right != null) {
            resultNode = this.right.infixOrderSearch(no);
        }
        return resultNode;
    }

    /**
     * 后序查找：左右根
     *
     * @return
     */
    public Node postOrderSearch(int no) {
        // 左
        Node resultNode = null;
        if (this.left != null) {
            resultNode = this.left.postOrderSearch(no);
        }
        if (resultNode != null) {
            return resultNode;
        }

        // 右
        if (this.right != null) {
            resultNode = this.right.postOrderSearch(no);
        }
        if (resultNode != null) {
            return resultNode;
        }
        // 根
        if (this.no == no) {
            return this;
        }
        return resultNode;
    }

}
