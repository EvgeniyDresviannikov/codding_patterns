package in.place.manipulation.linkedList;

public class ReverseKGroups {

    public static void main(String[] args) {
        LinkedListNode node8 = new LinkedListNode(8);
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

        LinkedListNode temp = reverseKGroups(node1, 3);

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static LinkedListNode reverseKGroups(LinkedListNode head, int k) {

       return head;
    }
}


