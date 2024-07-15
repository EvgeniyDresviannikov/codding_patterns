package hash.maps;


public class DesignHashMap {

    int CAPACITY = 3000;
    Bucket[] buckets = new Bucket[CAPACITY];

    public static void main(String[] args) {
        DesignHashMap designHashMap = new DesignHashMap();
        designHashMap.put(1, 2);
        designHashMap.put(3, 4);
        designHashMap.put(3001, 5);
        System.out.println(designHashMap.get(1));
        System.out.println(designHashMap.get(3001));
        System.out.println(designHashMap.get(3));

        designHashMap.remove(3);
        System.out.println(designHashMap.get(3));

    }

    public DesignHashMap() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
    }

    public void put(int key, int value) {
        int bucketIndex = key % CAPACITY;
        buckets[bucketIndex].update(key, value);
    }

    public int get(int key) {
        int bucketIndex = key % CAPACITY;
        return buckets[bucketIndex].get(key);
    }

    public void remove(int key) {
        int bucketIndex = key % CAPACITY;
        buckets[bucketIndex].remove(key);
    }
}
