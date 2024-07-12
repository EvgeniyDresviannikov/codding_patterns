package tree.breadth.first.search;


public class PopulatingNextRightPointersInEachNode {

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

        System.out.println(populateNextPointers(root).left.next.data);
    }

    public static EduTreeNode<Integer> populateNextPointers(EduTreeNode<Integer> root) {

        if (root == null) {
            return null;
        }

        EduTreeNode<Integer> mostLeft = root;

        while (mostLeft.left != null) {
            EduTreeNode<Integer> current = mostLeft;

            while (current != null) {
                current.left.next = current.right;

                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                current = current.next;

            }

            mostLeft = mostLeft.left;


        }

        return root;
    }
}
