package custom.data.structures;

public class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;
    public LinkedListNode<T> prev;

    public LinkedListNode(T dataVal) {
        this.data = dataVal;
        this.next = null;
        this.prev = null;
    }
}
