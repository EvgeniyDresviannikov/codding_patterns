package custom.data.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomSet {

    public static void main(String[] args) {
        RandomSet randomSet = new RandomSet();
        randomSet.insert(1);
        randomSet.insert(3);
        randomSet.insert(9);
        randomSet.insert(4);


        System.out.println(randomSet.getRandomData());
        System.out.println(randomSet.getRandomData());
        System.out.println(randomSet.getRandomData());
        System.out.println(randomSet.getRandomData());
        System.out.println(randomSet.getRandomData());
        System.out.println(randomSet.getRandomData());
        System.out.println(randomSet.getRandomData());
    }

    private int[] arr = new int[100];
    private Map<Integer, Integer> map = new HashMap<>();
    private Random random = new Random();

    public RandomSet() {

    }


    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        int index = map.size();
        map.put(val, index);
        arr[index] = val;

        return true;

    }


    public boolean delete(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.get(val);
        arr[index] = arr[map.size()-1];
        map.remove(val);

        return true;
    }


    public int getRandomData() {
        int randomIdx = random.nextInt(map.size());
        return arr[randomIdx];
    }
}