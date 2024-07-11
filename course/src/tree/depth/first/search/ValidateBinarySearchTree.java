package tree.depth.first.search;

public class ValidateBinarySearchTree {

    static int prev = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode<Integer> left = new TreeNode<>(5);
        TreeNode<Integer> right = new TreeNode<>(15);
        TreeNode<Integer> root = new TreeNode<>(10);
        root.right = right;
        root.left = left;

        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(7);

        left.left = node1;
        left.right = node2;

        System.out.println(validateBst(root));
    }

    public static boolean validateBst (TreeNode<Integer> root) {


        return dfs(root);
    }

    private static boolean dfs(TreeNode<Integer> node) {
        if (node == null) return true;

        if (!dfs(node.left)) return false;

        if (prev >= node.data) {
            return false;
        } else {
            prev = node.data;
        }

        return dfs(node.right);
    }
}
