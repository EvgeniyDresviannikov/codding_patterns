package tree.breadth.first.search;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);


        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode<Integer> root) {

        if (root == null) return false;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode<Integer> left = queue.poll();
            TreeNode<Integer> right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (!Objects.equals(left.data, right.data)) return false;


            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);

        }

        return true;
    }
}
