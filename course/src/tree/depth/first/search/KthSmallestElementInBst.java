package tree.depth.first.search;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBst {
    static List<Integer> lst = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode<Integer> left = new TreeNode<>(5);
        TreeNode<Integer> right = new TreeNode<>(15);
        TreeNode<Integer> root = new TreeNode<>(10);
        root.right = right;
        root.left = left;

        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(7);

        left.left = node1;
        left.right = node2;

        System.out.println(kthSmallestElement(root, 5));
    }

    public static int kthSmallestElement(TreeNode<Integer> root, int k) {

        dfs(root);

        return lst.get(k-1);
    }

    private static void dfs(TreeNode<Integer> node) {
        if (node == null) return;

        dfs(node.left);

        lst.add(node.data);

        dfs(node.right);

    }
}
