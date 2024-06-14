package in.place.manipulation.linkedList;

public class ReorderList {

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

        LinkedListNode temp = reorderList(node1);

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static LinkedListNode reorderList(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head;
        LinkedListNode nodeBeforeMiddle = null;

        // find middle
        while (fast != null && fast.next != null) {
            fast = fast.next;
            fast = fast.next;
            nodeBeforeMiddle = slow;
            slow = slow.next;
        }

        if (nodeBeforeMiddle == null) return head;

        LinkedListNode middle = slow;

        // reverse second half
        LinkedListNode prev = middle;
        LinkedListNode curr = middle.next;
        middle.next = null;
        LinkedListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }


        nodeBeforeMiddle.next = prev;
        middle = prev;

        // merge
        LinkedListNode tmp = head;
        LinkedListNode tmp2 = middle;
        LinkedListNode next2 = null;
        while(tmp != middle) {
            next = tmp.next;
            next2 = tmp2.next;

            tmp.next = tmp2;
            tmp2.next = next;
            prev = tmp2;
            tmp = next;
            tmp2 = next2;

        }

        prev.next = tmp2;
        //if (tmp2.next != null);

        return head;
    }
}
