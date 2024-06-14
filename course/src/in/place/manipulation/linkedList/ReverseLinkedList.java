package in.place.manipulation.linkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedListNode node9 = new LinkedListNode(9);
        LinkedListNode node8 = new LinkedListNode(8);
        node8.next = node9;
        LinkedListNode node7 = new LinkedListNode(7);
        node7.next = node8;
        LinkedListNode node6 = new LinkedListNode(6);
        node6.next = node7;
        LinkedListNode node5 = new LinkedListNode(5);
        node5.next = node6;
        LinkedListNode node4 = new LinkedListNode(4);
        node4.next = node5;
        LinkedListNode node3 = new LinkedListNode(3);
        node3.next = node4;
        LinkedListNode node2 = new LinkedListNode(2);
        node2.next = node3;
        LinkedListNode node1 = new LinkedListNode(1);
        node1.next = node2;

        LinkedListNode head = reverse(node1);

        LinkedListNode temp = head;
        System.out.println(temp.data);
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp.data);
        }

    }

    public static LinkedListNode reverse(LinkedListNode head) {

        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}

class LinkedListNode {
    public int data;
    public LinkedListNode next;
    // Constructor will be used to make a LinkedListNode type object
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
