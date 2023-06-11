package tree;

public class CommonAncestorTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.generate(3);

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(3);
        TreeNode res = lowestCommonAncestor(treeNode, p, q);
        System.out.println(res);


    }

    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p , TreeNode q){
        if(root == null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;


    }

}
