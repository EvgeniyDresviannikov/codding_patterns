package backtracking;

public class HouseRobber3 {

    public static void main(String[] args) {
        TreeNode<Integer> node6 = new TreeNode<>(12);
        TreeNode<Integer> node5 = new TreeNode<>(10);
        TreeNode<Integer> node4 = new TreeNode<>(8);
        TreeNode<Integer> node3 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(11);
        node2.left = node5;
        node2.right = node6;
        TreeNode<Integer> node1 = new TreeNode<>(7);
        node1.left = node3;
        node1.right = node4;
        TreeNode<Integer> node0 = new TreeNode<>(9);
        node0.left = node1;
        node0.right = node2;

        System.out.println(rob(node0));
    }

    public static int rob(TreeNode<Integer> root) {
        int[] result = backtrack(root);
        return Math.max(result[0], result[1]);
    }

    // return [withRoot, withoutRoot]
    private static int[] backtrack(TreeNode<Integer> node) {
        if (node == null) return new int[]{0, 0};

        TreeNode<Integer> left = node.left;
        TreeNode<Integer> right = node.right;

        int[] leftPair = backtrack(left);
        int[] rightPair = backtrack(right);



        int withRoot = node.data + leftPair[1] + rightPair[1];
        int withoutRoot = Math.max(leftPair[0], leftPair[1]) + Math.max(rightPair[0], rightPair[1]);


        return new int[]{withRoot, withoutRoot};
    }
}

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
