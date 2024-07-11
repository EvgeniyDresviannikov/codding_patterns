package tree.depth.first.search;

public class LowestCommonAncestorInBinaryTree {

    public static void main(String[] args) {
        TreeNode<Integer> left = new TreeNode<>(2);
        TreeNode<Integer> right = new TreeNode<>(3);
        TreeNode<Integer> root = new TreeNode<>(1);
        root.right = right;
        root.left = left;

        TreeNode<Integer> node1 = new TreeNode<>(4);
        TreeNode<Integer> node2 = new TreeNode<>(5);

        left.left = node1;
        left.right = node2;

        System.out.println(lowestCommonAncestor(root, left, node1).data);
    }

    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {

        return dfs(root, p, q);
    }

    private static TreeNode<Integer> dfs(TreeNode<Integer> current, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (current == null) return null;
        if (p == current) return p;
        if (q == current) return q;

        TreeNode<Integer> leftRes = dfs(current.left, p, q);
        TreeNode<Integer> rightRes = dfs(current.right, p, q);

        if (leftRes != null && rightRes != null) {
            return current;
        } else if (leftRes != null) {
            return leftRes;
        } else if (rightRes != null) {
            return rightRes;
        } else {
            return null;
        }
    }
}
