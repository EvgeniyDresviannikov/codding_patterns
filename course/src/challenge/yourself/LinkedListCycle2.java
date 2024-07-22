package challenge.yourself;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {

    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(5);
        LinkedListNode node2 = new LinkedListNode(10);
        node1.next = node2;
        LinkedListNode node3 = new LinkedListNode(15);
        node2.next = node3;
        LinkedListNode node4 = new LinkedListNode(30);
        node3.next = node4;
        LinkedListNode node5 = new LinkedListNode(70);
        node4.next = node5;
        node5.next = node3;


        System.out.println(detectCycle(node1).data);
    }

    public static LinkedListNode detectCycle(LinkedListNode head) {

        Set<LinkedListNode> visited = new HashSet<>();

        while (head != null) {
            if (!visited.contains(head)) {
                visited.add(head);
            } else {
                return head;
            }
            head = head.next;
        }

        return null;
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