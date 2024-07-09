package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public static void main(String[] args) {
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        node1.neighbors = List.of(node2, node3);
        node2.neighbors = List.of(node1, node3);
        node3.neighbors = List.of(node1, node2);

        Node res = clone(node1);
        System.out.println(res);
    }

    public static Node clone(Node root) {

        Map<Node, Node> created = new HashMap<>();

        return backtrack(root, created);
    }

    private static Node backtrack(Node node, Map<Node, Node> created) {

        if (created.containsKey(node)) {
            return created.get(node);
        }

        Node cloneNode = new Node(node.data);
        created.put(node, cloneNode);

        for (int i = 0; i < node.neighbors.size(); i++) {
            Node neighbor = node.neighbors.get(i);
            cloneNode.neighbors.add(backtrack(neighbor, created));
        }
        return cloneNode;
    }

}



class Node {
    int data;
    List<Node> neighbors;

    public Node(int data) {
        this.data = data;
        this.neighbors = new ArrayList<Node>();
    }
}