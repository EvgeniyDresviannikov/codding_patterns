package tree.depth.first.search;

import java.util.Arrays;

public class BuildTreeFromPreorderAndInorder {

    public static void main(String[] args) {
        TreeNode<Integer> res = buildTree(new int[] {3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        print(res);
    }

    public static TreeNode<Integer> buildTree(int[] pOrder, int[] iOrder) {


        return dfs(pOrder, iOrder);
    }

    private static TreeNode<Integer> dfs(int[] pOrder, int[] iOrder) {
        if (pOrder.length == 0 && iOrder.length == 0) return null;

        TreeNode<Integer> node = new TreeNode<>(pOrder[0]);
        int index = -1;
        for (int i = 0; i < iOrder.length; i++) {
            if (iOrder[i] == pOrder[0]) {
                index = i;
                break;
            }
        }

        node.left = dfs(Arrays.copyOfRange(pOrder, 1, 1+index), Arrays.copyOfRange(iOrder, 0, index));
        node.right = dfs(Arrays.copyOfRange(pOrder, 1+index, pOrder.length), Arrays.copyOfRange(iOrder, 1+index, iOrder.length));

        return node;
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
