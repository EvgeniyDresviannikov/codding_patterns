package k.way.merge;

import java.util.List;

public class MergeKSortedLinkedLists {

    public static void main(String[] args) {

        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node2 = new LinkedListNode(2);
        node2.next = node3;
        LinkedListNode node1 = new LinkedListNode(1);
        node1.next = node2;


        LinkedListNode node5 = new LinkedListNode(5);
        LinkedListNode node4 = new LinkedListNode(4);
        node4.next = node5;

        LinkedListNode node9 = new LinkedListNode(9);
        LinkedListNode node8 = new LinkedListNode(8);
        node8.next = node9;
        LinkedListNode node7 = new LinkedListNode(7);
        node7.next = node8;
        LinkedListNode node6 = new LinkedListNode(6);
        node6.next = node7;

        LinkedList lst1 = new LinkedList();
        lst1.head = node1;

        LinkedList lst2 = new LinkedList();
        lst2.head = node4;

        LinkedList lst3 = new LinkedList();
        lst3.head = node6;

        LinkedListNode head = mergeKLists(List.of(lst1, lst2, lst3));

        LinkedListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;

        }
    }

    public static LinkedListNode mergeKLists(List<LinkedList> lists) {

        if (lists.isEmpty()) return null;
        if (lists.size() == 1) return lists.get(0).head;

        LinkedListNode linkedListNode1 = lists.get(0).head;
        LinkedListNode linkedListNode2 = lists.get(1).head;

        LinkedListNode tmp = merge2lists(linkedListNode1, linkedListNode2);

        for (int i = 2; i < lists.size(); i++) {
            LinkedListNode tmp2 = lists.get(i).head;
            tmp = merge2lists(tmp, tmp2);
        }

        return tmp;
    }

    private static LinkedListNode merge2lists(LinkedListNode linkedListNode1, LinkedListNode linkedListNode2) {
        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode tmp = dummy;

        while (linkedListNode1 != null && linkedListNode2 != null) {
            if (linkedListNode1.data < linkedListNode2.data) {
                tmp.next = new LinkedListNode(linkedListNode1.data);
                linkedListNode1 = linkedListNode1.next;
            } else {
                tmp.next = new LinkedListNode(linkedListNode2.data);
                linkedListNode2 = linkedListNode2.next;
            }
            tmp = tmp.next;
        }

        if (linkedListNode1 == null) {
            tmp.next = linkedListNode2;
        } else {
            tmp.next = linkedListNode1;
        }

        return dummy.next;
    }
}




class LinkedListNode {
    public int data;
    public LinkedListNode next;
    // LinkedListNode() will be used to make a LinkedListNode type object.
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    public LinkedListNode head;
    // LinkedList() will be used to make a LinkedList type object.
    public LinkedList() {
        this.head = null;
    }
    // insert_node_at_head method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    // create_linked_list method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(List<Integer> lst) {
        for (int i = lst.size() - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst.get(i));
            insertNodeAtHead(newNode);
        }
    }
}
