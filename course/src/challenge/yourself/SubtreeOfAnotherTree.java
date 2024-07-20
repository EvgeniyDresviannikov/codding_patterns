package challenge.yourself;

import java.util.ArrayDeque;
import java.util.Queue;

public class SubtreeOfAnotherTree {

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

        TreeNode<Integer> sub1 = new TreeNode<>(2);
        TreeNode<Integer> sub2 = new TreeNode<>(4);
        TreeNode<Integer> sub3 = new TreeNode<>(5);
        sub1.left = sub2;
        sub1.right = sub3;

        System.out.println(isSubtree(root, sub1));
    }

    public static boolean isSubtree(TreeNode<Integer> root, TreeNode<Integer> subRoot) {

        if (subRoot == null || subRoot.left == null || subRoot.right == null) return false;

        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        Queue<TreeNode<Integer>> next = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<Integer> pop = queue.poll();
            if (pop.left != null) next.add(pop.left);
            if (pop.right != null) next.add(pop.right);
            if (pop.data.equals(subRoot.data)) {
                if (dfs(pop.left, subRoot.left) && dfs(pop.right, subRoot.right)) return true;
            }
            if (queue.isEmpty()) {
                while (!next.isEmpty()) {
                    queue.add(next.poll());
                }
            }
        }

        return false;
    }

    private static boolean dfs(TreeNode<Integer> treeNode, TreeNode<Integer> subTreeNode) {
        if (treeNode == null && subTreeNode == null) return true;

        if (treeNode == null || subTreeNode == null) return false;

        if (!treeNode.data.equals(subTreeNode.data)) return false;

        return dfs(treeNode.left, subTreeNode.left) && dfs(treeNode.right, subTreeNode.right);

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
