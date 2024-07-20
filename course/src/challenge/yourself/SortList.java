package challenge.yourself;

public class SortList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(7);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(9);
        node3.next = node4;
        ListNode node5 = new ListNode(8);
        node4.next = node5;

        ListNode res = sortList(node1);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode sortList(ListNode head) {

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode lastHandled = dummy;
        ListNode tmp = head;

        while (tmp != null) {
            if (tmp.val >= lastHandled.val) {
                lastHandled = tmp;
                tmp = tmp.next;
                continue;
            }

            lastHandled.next = tmp.next == null ? null : tmp.next;

            // recover order from head
            ListNode tmp1 = dummy;
            while (tmp1.next.val <= tmp.val) {
                tmp1 = tmp1.next;
            }
            ListNode nxt = tmp1.next;
            ListNode node = new ListNode(tmp.val);
            tmp1.next = node;
            node.next = nxt;

            tmp = lastHandled;
        }

        return dummy.next;
    }
}
