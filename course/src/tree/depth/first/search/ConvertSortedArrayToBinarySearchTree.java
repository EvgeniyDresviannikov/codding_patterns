package tree.depth.first.search;

import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        TreeNode<Integer> res = sortedArrayToBST(new int[] {1, 3, 5, 10, 15, 20, 24, 31, 32});

        print(res);
    }

    public static TreeNode<Integer> sortedArrayToBST(int[] nums) {

        TreeNode<Integer> res = dfs(nums);
        return res;
    }

    private static TreeNode<Integer> dfs(int[] arr) {
        if (arr.length == 0) return null;
        if (arr.length == 1) return new TreeNode<>(arr[0]);

        int len = arr.length;
        int middle = len / 2;

        TreeNode<Integer> child = new TreeNode<>(arr[middle]);
        child.left = dfs(Arrays.copyOfRange(arr, 0, middle));
        child.right = dfs(Arrays.copyOfRange(arr, middle+1, arr.length));

        return child;

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
