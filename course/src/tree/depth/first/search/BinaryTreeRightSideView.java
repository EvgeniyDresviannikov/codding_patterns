package tree.depth.first.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeRightSideView {

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

        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode<Integer> root) {

        if (root == null) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();

        dfs(0, root, res);

        return res;
    }

    private static void dfs(int level, TreeNode<Integer> node, List<Integer> res) {
        if (node == null) return;

        if (res.size() <= level) {
            res.add(node.data);
        }
        dfs(level+1, node.right, res);
        dfs(level+1, node.left, res);
    }
}
