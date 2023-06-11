//package examination;
//
//import java.util.ArrayList;
//
//public class Solution {
//    public static TreeNode lowestCommonAncestor (TreeNode root,TreeNode node1,TreeNode node2){
//        if (root==null || root==node1 || root==node2) {
//            return root;
//        }
//        //采用递归调用的思路，将二叉树分为左子树和右子树分别处理
//        //使用递归需要注意两点：
//        //1.子问题需与原始问题为同样的问题，且更为简单；2.不能无限制地调用本身，程序必须有出口
//        //查看左子树中是否有目标结点，没有为null
//        TreeNode left = lowestCommonAncestor(root.left,node1,node2);
//        //查看右子树是否有目标节点，没有为null
//        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
//        //都不为空，说明做右子树都有目标结点，则公共祖先就是本身
//        if((left==node1 && right==node2 ) || (left==node2 && right==node1)) {
//            return root;
//        }
//        return left==null?right:left;
//    }
//
//    /**
//     *  获取某一节点至其某祖先节点的路经
//     */
//    public static boolean getPath(TreeNode root,TreeNode target,ArrayList<TreeNode> pathList){
//        if (root==target)
//            return true;
//        pathList.add(root);
//        boolean hasFound=false;
//        if (root.left!=null)
//            hasFound=getPath(root.left,target,pathList);
//        if (!hasFound && root.right!=null)
//            hasFound=getPath(root.right,target,pathList);
//        if (!hasFound)
//            pathList.remove(pathList.size()-1);
//        return hasFound;
//    }
//
//    public static int getLength(TreeNode root,TreeNode node1,TreeNode node2){
//        ArrayList<TreeNode> pathList1=new ArrayList<>();
//        ArrayList<TreeNode> pathList2=new ArrayList<>();
//        //求出两个节点的最近公共祖先
//        TreeNode ancestor=lowestCommonAncestor(root,node1,node2);
//        //分别求出公共祖先到两个节点的路经长
//        int l1=getPath(ancestor,node1,pathList1);
//        int l2=getPath(ancestor,node2,pathList2);
//        return (l1+l2);
//    }
//
//    public static void main(String[] args) {
//        TreeNode root=new TreeNode(1);
//        TreeNode node2=new TreeNode(2);
//        TreeNode node3=new TreeNode(3);
//        root.left=node2;
//        root.right=node3;
//        TreeNode node4=new TreeNode(4);
//        TreeNode node5=new TreeNode(5);
//        node2.left=node4;
//        node2.right=node5;
//        TreeNode node6=new TreeNode(6);
//        TreeNode node7=new TreeNode(7);
//        node3.left=node6;
//        node3.right=node7;
//
//        ArrayList<TreeNode> pathList1=new ArrayList<TreeNode>();
//        ArrayList<TreeNode> pathList2=new ArrayList<TreeNode>();
//        getPath(root,node5,pathList1);
//        getPath(root,node2,pathList2);
//        int res=pathList1.size()+pathList2.size();
//        System.out.println(res);
//        // for (TreeNode treeNode:pathList)
//        //  System.out.println(treeNode.val);
//    }
//}
//
//
//class TreeNode{
//    public int val;
//    public TreeNode left;
//    public TreeNode right;
//    public TreeNode(int val){
//        this.val=val;
//    }
//}