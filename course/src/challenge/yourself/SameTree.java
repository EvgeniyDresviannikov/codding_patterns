package challenge.yourself;

import java.util.ArrayDeque;
import java.util.Queue;

public class SameTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        node4.left = node5;
        node4.right = node6;


        System.out.println(sameTree(node1, node4));
    }

    public static boolean sameTree(TreeNode<Integer> p, TreeNode<Integer> q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (!p.data.equals(q.data)) {
            return false;
        }


        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }

    private static boolean dfs(TreeNode<Integer> node1, TreeNode<Integer> node2) {
        if (node1 == null && node2 == null) return true;

        if (node1 == null || node2 == null) return false;

        if (!node1.data.equals(node2.data)) return false;

        return dfs(node1.left, node2.left) && dfs(node1.right, node2.right);
    }
}
