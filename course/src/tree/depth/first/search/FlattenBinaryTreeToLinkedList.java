package tree.depth.first.search;

public class FlattenBinaryTreeToLinkedList {

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

        TreeNode<Integer> head = flattenTree(root);

        while (head != null) {
            System.out.println(head.val);
            head = head.right;
        }
    }

    public static TreeNode<Integer> flattenTree(TreeNode<Integer> root) {

        if (root == null) return null;

        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                TreeNode last = current.left;
                while (last.right != null) {
                    last = last.right;
                }
                last.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }

        return root;

    }


}



class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}