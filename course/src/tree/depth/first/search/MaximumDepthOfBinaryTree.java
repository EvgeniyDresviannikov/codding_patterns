package tree.depth.first.search;

public class MaximumDepthOfBinaryTree {

    static int maxPath = 0;

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

        System.out.println(findMaxDepth(root)); // 26
    }

    public static int findMaxDepth(TreeNode<Integer> root) {

        dfs(root, 0);
        return maxPath;
    }

    private static void dfs(TreeNode<Integer> node, int level) {
        if (node == null) {
            maxPath = Math.max(maxPath, level);
            return;
        }

        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }
}
