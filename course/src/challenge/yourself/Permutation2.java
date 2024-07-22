package challenge.yourself;

import java.util.*;

public class Permutation2 {

    static List<List<Integer>> res = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) {
        System.out.println(printUniquePermutations(new int[]{1,1,2}));
    }

    public static List<List<Integer>> printUniquePermutations(int[] nums) {

        arr = nums;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
        }

        List<Integer> perm = new ArrayList<>();
        backtrack(freq, perm);

        return res;
    }

    private static void backtrack(Map<Integer, Integer> freq, List<Integer> currentPerm) {
        if (currentPerm.size() == arr.length) {
            res.add(new ArrayList<>(currentPerm));
            return;
        }

        List<Integer> keys = new ArrayList<>(freq.keySet());

        keys.forEach(key -> {
            int count = freq.get(key);
            if (count > 0) {
                currentPerm.add(key);
                freq.put(key, count - 1);

                backtrack(freq, currentPerm);

                freq.put(key, count);
                currentPerm.remove(currentPerm.size()-1);
            }
        });
    }
}
