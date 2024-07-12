package tree.depth.first.search;

public class BinaryTreeMaximumPathSum {

    static int res = Integer.MIN_VALUE;

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

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode<Integer> root) {

        dfs(root);
        return res;
    }

    private static int dfs(TreeNode<Integer> node) {
        if (node == null) return 0;

        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);

        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        res = Math.max(res, node.data + leftMax + rightMax);

        return node.data + Math.max(leftMax, rightMax);
    }
}
