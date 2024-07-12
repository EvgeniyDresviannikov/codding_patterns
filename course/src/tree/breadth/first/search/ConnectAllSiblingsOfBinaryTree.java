package tree.breadth.first.search;

public class ConnectAllSiblingsOfBinaryTree {

    public static void main(String[] args) {
        EduTreeNode<Integer> left = new EduTreeNode<>(2);
        EduTreeNode<Integer> right = new EduTreeNode<>(3);
        EduTreeNode<Integer> root = new EduTreeNode<>(1);
        root.right = right;
        root.left = left;

        EduTreeNode<Integer> node1 = new EduTreeNode<>(4);
        EduTreeNode<Integer> node2 = new EduTreeNode<>(5);

        left.left = node1;
        left.right = node2;

        EduTreeNode<Integer> node3 = new EduTreeNode<>(6);
        EduTreeNode<Integer> node4 = new EduTreeNode<>(7);

        right.left = node3;
        right.right = node4;

        System.out.println(connectAllSiblings(root).next.data);
    }

    public static EduTreeNode<Integer> connectAllSiblings(EduTreeNode<Integer> root) {

        if (root == null) {
            return null;
        }

        EduTreeNode<Integer> mostLeft = root;

        while (mostLeft.left != null) {
            EduTreeNode<Integer> current = mostLeft;
            EduTreeNode<Integer> prev = mostLeft;

            while (current != null) {
                current.left.next = current.right;

                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                prev = current;
                current = current.next;

            }

            mostLeft = mostLeft.left;
            prev.next = mostLeft;

        }

        return root;
    }
}
