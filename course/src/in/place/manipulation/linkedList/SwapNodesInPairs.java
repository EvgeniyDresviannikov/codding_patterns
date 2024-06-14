package in.place.manipulation.linkedList;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        LinkedListNode node5 = new LinkedListNode(5);
        LinkedListNode node4 = new LinkedListNode(4);
        node4.next = node5;
        LinkedListNode node3 = new LinkedListNode(3);
        node3.next = node4;
        LinkedListNode node2 = new LinkedListNode(2);
        node2.next = node3;
        LinkedListNode node1 = new LinkedListNode(1);
        node1.next = node2;

        LinkedListNode temp = swapPairs(node1);

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static LinkedListNode swapPairs(LinkedListNode head) {

        if (head == null) return head;
        if (head.next == null) return head;

        LinkedListNode curr = head;
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode next = curr.next;
        LinkedListNode prev = dummy;


        while (true) {
            LinkedListNode tmp = next.next;
            curr.next = tmp;
            next.next = curr;
            prev.next = next;
            prev = curr;
            curr = tmp;
            if (curr == null) break;
            next = curr.next;
            if (next == null) break;
        }

        return dummy.next;
    }
}
