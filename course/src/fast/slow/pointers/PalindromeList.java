package fast.slow.pointers;

public class PalindromeList {

    public static void main(String[] args) {
        LinkedListNode node8 = new LinkedListNode(1);
        LinkedListNode node7 = new LinkedListNode(2);
        node7.next = node8;
        LinkedListNode node6 = new LinkedListNode(3);
        node6.next = node7;
        LinkedListNode node5 = new LinkedListNode(4);
        node5.next = node6;
        LinkedListNode node4 = new LinkedListNode(4);
        node4.next = node5;
        LinkedListNode node3 = new LinkedListNode(3);
        node3.next = node4;
        LinkedListNode node2 = new LinkedListNode(2);
        node2.next = node3;
        LinkedListNode node1 = new LinkedListNode(1);
        node1.next = node2;

        System.out.println(palindrome(node1));
        while (node1 != null) {
            System.out.println(node1.data);
            node1 = node1.next;
        }
    }

    public static boolean palindrome(LinkedListNode head) {

        LinkedListNode fast = head;
        LinkedListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

       LinkedListNode revertData = reverseLinkedList(slow);

        boolean check = compareTwoHalves(head, revertData);

        reverseLinkedList(revertData);

        if (check) {
            return true;
        }

        return false;
    }

    private static LinkedListNode reverseLinkedList(LinkedListNode node) {
        LinkedListNode prev = null;
        LinkedListNode next = null;
        LinkedListNode curr = node;

        while (curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static boolean compareTwoHalves(LinkedListNode firstHalf, LinkedListNode secondHalf) {
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            } else {
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }


        }
        return true;
    }
}

