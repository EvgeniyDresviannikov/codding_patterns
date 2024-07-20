package challenge.yourself;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 4, 6, 8, 10, 19}, 21)));
    }

    public static int[] twoSum(int[] arr, int t) {

        Map<Integer, Integer> visited = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (visited.containsKey(t - arr[i])) {
                return new int[]{visited.get(t - arr[i]), i};
            }
            visited.put(arr[i], i);
        }

        return new int[]{};
    }
}
