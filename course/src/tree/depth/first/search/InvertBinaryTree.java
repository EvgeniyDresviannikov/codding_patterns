package tree.depth.first.search;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode<Integer> left = new TreeNode<>(2);
        TreeNode<Integer> right = new TreeNode<>(17);
        TreeNode<Integer> root = new TreeNode<>(3);
        root.right = right;
        root.left = left;

        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(4);

        left.left = node1;
        left.right = node2;

        print(root);
        System.out.println("--------inverted:---------");
        print(invertTree(root));
    }

    public static TreeNode<Integer> invertTree(TreeNode<Integer> root){

        bfs(root);
        return root;
    }

    private static void bfs(TreeNode<Integer> node) {
        if (node == null || (node.left == null && node.right == null)) return;

        TreeNode<Integer> tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        bfs(node.left);
        bfs(node.right);
    }

    private static void print(TreeNode<Integer> node) {
        if (node == null) {
            System.out.println("null");
            return;
        }

        System.out.println(node.data);
        print(node.left);
        print(node.right);
    }
}
