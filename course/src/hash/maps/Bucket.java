package hash.maps;

import java.util.ArrayList;

public class Bucket {

    private ArrayList<Pair<Integer, Integer>> bucket;

    // Initialize bucket here
    public Bucket() {
        bucket = new ArrayList<Pair<Integer, Integer>>();
    }
    // put value in bucket
    public void update(int key, int value) {

        for (Pair<Integer, Integer> pair : bucket) {
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }

        bucket.add(new Pair<>(key, value));
    }
    // get value from bucket
    public int get(int key) {
        for (Pair<Integer, Integer> pair : bucket) {
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }

        return - 1;
    }
    // delete value from bucket
    public void remove(int key) {
        int indexForRemove = -1;
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getKey() == key) {
                indexForRemove = i;
                break;
            }
        }

        if (indexForRemove != -1) {
            bucket.remove(indexForRemove);
        }
    }
}

class Pair<K, V> {
    private K key;
    private V value;


    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
