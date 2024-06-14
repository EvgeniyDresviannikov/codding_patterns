package in.place.manipulation.linkedList;

public class SwappingNodesInLinkedList {

    public static void main(String[] args) {

        LinkedListNode node6 = new LinkedListNode(6);
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

        LinkedListNode temp = swapNodes(node1, 3);

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static LinkedListNode swapNodes(LinkedListNode head, int k) {

        int counter = 1;
        LinkedListNode front = head;

        // find front
        while (counter < k) {
            front = front.next;
            counter++;
        }

        LinkedListNode end = head;

        LinkedListNode tmp = front;

        // find end
        while (tmp.next != null) {
            tmp = tmp.next;
            end = end.next;
        }

        // swap
        swap(front ,end);

        return head;
    }

    public static void swap(LinkedListNode node1, LinkedListNode node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }
}
