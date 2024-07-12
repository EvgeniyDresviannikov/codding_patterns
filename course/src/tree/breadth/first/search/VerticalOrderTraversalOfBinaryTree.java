package tree.breadth.first.search;

import java.util.*;

class Pair {
    int index;
    TreeNode<Integer> node;

    public Pair(int index, TreeNode<Integer> node) {
        this.index = index;
        this.node = node;
    }
}

public class VerticalOrderTraversalOfBinaryTree {

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

        System.out.println(verticalOrder(root));
    }

    public static List<List<Integer>> verticalOrder(TreeNode<Integer> root) {

        if (root == null) return new ArrayList<>();

        Map<Integer, List<Integer>> columnToList = new HashMap<>();
        Queue<Pair> current = new ArrayDeque<>();
        Queue<Pair> next = new PriorityQueue<>((o1, o2) -> {
            if (o1.index != o2.index) {
                return o1.index - o2.index;
            } else {
                return o1.node.data - o2.node.data;
            }
        });

        current.add(new Pair(0, root));

        while (!current.isEmpty()) {
            Pair top = current.poll();
            if (columnToList.containsKey(top.index)) {
                columnToList.get(top.index).add(top.node.data);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(top.node.data);
                columnToList.put(top.index, tmp);
            }


            if (top.node.left != null) {
                next.add(new Pair(top.index-1, top.node.left));
            }
            if (top.node.right != null) {
                next.add(new Pair(top.index+1, top.node.right));
            }

            if (current.isEmpty()) {
                while (!next.isEmpty()) {
                    current.add(next.poll());
                }
            }

        }

        int minIndex = columnToList.keySet().stream().min(Comparator.comparingInt(k -> k)).get();
        int size = columnToList.size();

        List<List<Integer>> res = new ArrayList<>();

        for (int i = minIndex; i < minIndex + size; i++) {
            List<Integer> lst = columnToList.get(i);
            res.add(lst);
        }

        return res;
    }
}
