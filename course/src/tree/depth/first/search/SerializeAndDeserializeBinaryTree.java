package tree.depth.first.search;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {

    static int index = 0;

    public static void main(String[] args) {
        TreeNode<Integer> left = new TreeNode<>(2);
        TreeNode<Integer> right = new TreeNode<>(5);
        right.right = new TreeNode<>(6);

        TreeNode<Integer> root = new TreeNode<>(1);
        root.right = right;
        root.left = left;

        TreeNode<Integer> node1 = new TreeNode<>(3);
        TreeNode<Integer> node2 = new TreeNode<>(4);

        left.left = node1;
        left.right = node2;

        List<String> ser = serialize(root);
        System.out.println(ser);

        TreeNode<Integer> deserialized = deserialize(ser);

        System.out.println(serialize(deserialized));
    }

    public static List<String> serialize(TreeNode<Integer> root) {

        List<String> result = new ArrayList<>();
        dfsSerialize(root, result);
        return result;
    }
    public static TreeNode<Integer> deserialize(List<String> stream){

        if (stream.isEmpty() || (stream.size() == 1 && stream.get(0).equals("NULL"))) return null;
        if (stream.size() == 1) return new TreeNode<>(Integer.valueOf(stream.get(0)));

        return dfsDeserialize(stream);
    }

    private static void dfsSerialize(TreeNode<Integer> node, List<String> stream) {

        if (node == null) {
            stream.add("NULL");
            return;
        }

        stream.add(node.data.toString());

        dfsSerialize(node.left, stream);
        dfsSerialize(node.right, stream);

    }

    private static TreeNode<Integer> dfsDeserialize(List<String> stream) {
        if (stream.get(index).equals("NULL")) {
            index++;
            return null;
        }

        TreeNode<Integer> node = new TreeNode<>(Integer.valueOf(stream.get(index)));
        index++;
        node.left = dfsDeserialize(stream);
        node.right = dfsDeserialize(stream);

        return node;
    }
}
