package tree.breadth.first.search;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

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

        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {

        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode<Integer>> current = new ArrayDeque<>();
        Queue<TreeNode<Integer>> next = new ArrayDeque<>();

        current.add(root);

        List<Integer> tmp = new ArrayList<>();
        while (!current.isEmpty()) {
            TreeNode<Integer> top = current.poll();

            if (top.left != null) {
                next.add(top.left);
            }

            if (top.right != null) {
                next.add(top.right);
            }
            tmp.add(top.data);
            if (current.isEmpty()) {

                if (res.size() % 2 == 1) {
                    List<Integer> reversed = new ArrayList<>();
                    for (int i = tmp.size()-1; i > -1; i--) {
                        reversed.add(tmp.get(i));
                    }
                    tmp = reversed;
                }

                res.add(tmp);

                tmp = new ArrayList<>();
                while (!next.isEmpty()) {
                    current.add(next.poll());
                }
            }


        }
        return res;
    }
}
