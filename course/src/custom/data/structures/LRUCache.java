package custom.data.structures;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1, 100);
        lruCache.set(2, 200);
        lruCache.set(3, 300);
        lruCache.set(4, 400);
        System.out.println(lruCache.get(1));
    }



    private Map<Integer, LinkedListNode<Map.Entry<Integer, Integer>>> map;
    private int capacity;
    private LinkedList<Map.Entry<Integer, Integer>> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new LinkedList<>();
    }

    int get(int key) {
        LinkedListNode<Map.Entry<Integer, Integer>> node = map.get(key);
        if (node == null) return -1;

        LinkedListNode<Map.Entry<Integer, Integer>> next = node.next;
        LinkedListNode<Map.Entry<Integer, Integer>> prev = node.prev;

        // already least recently used
        if (prev == null) {
            return node.data.getValue();
        }

        if (next == null) {
            prev.next = null;
        } else {
            prev.next = next;
            next.prev = prev;
        }

        cache.remove(node);
        cache.insertAtHead(node.data);

        return node.data.getValue();
    }

    void set(int key, int value) {
        LinkedListNode<Map.Entry<Integer, Integer>> current = map.get(key);
        if (current == null) {
            if (map.size() == capacity) {
                LinkedListNode<Map.Entry<Integer, Integer>> itemForRemove = cache.getLast();
                map.remove(itemForRemove.data.getKey());
                cache.removeLast();
            }

            cache.insertAtHead(Map.entry(key, value));
            map.put(key, cache.getFirst());
        } else {
            current.data = Map.entry(key, value);
            get(key);
        }
    }
}
