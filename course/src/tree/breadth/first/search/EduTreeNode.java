package tree.breadth.first.search;

class EduTreeNode<T> {
    T data;
    EduTreeNode<T> left;
    EduTreeNode<T> right;
    EduTreeNode<T> next;

    EduTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}
