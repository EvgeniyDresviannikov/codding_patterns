package in.place.manipulation.linkedList;


public class ReverseLinkedList2 {

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

        LinkedListNode head = reverseBetween(node1, 1, 5);

        LinkedListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;

        }
    }

    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {

        LinkedListNode current = head;
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode nodeBeforeLeft = dummy;
        LinkedListNode nodeLeft = null;
        LinkedListNode nodeAfterRight = null;


        int counter = 0;

        while (counter < right) {
            counter++;
            if (counter == left-1) {
                nodeBeforeLeft = current;
            }

            if (counter == left) {
                nodeLeft = current;
            }

            if (counter == right) {
                nodeAfterRight = current.next;
            }

            current = current.next;
        }

        LinkedListNode prev = nodeBeforeLeft.next;
        current = prev.next;
        LinkedListNode next = null;

        while(current != nodeAfterRight) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }


        nodeBeforeLeft.next = prev;
        nodeLeft.next = nodeAfterRight;

        return dummy.next;
    }
}
