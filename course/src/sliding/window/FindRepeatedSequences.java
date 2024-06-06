package sliding.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindRepeatedSequences {

    public static void main(String[] args) {
        System.out.println(findRepeatedSequences("CAAACCCCGTAAACCCCA", 7));
    }

    public static Set<String> findRepeatedSequences(String s, int k) {

        if (k > s.length()) return new HashSet<>();

        Map<Character,Integer> intValue = Map.of('A', 1, 'C', 2, 'G', 3, 'T', 4);

        int[] numbers = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            numbers[i] = intValue.get(s.charAt(i));
        }

        int hash = 0;
        int a = 4;
        for (int i = 0; i < k; i++) {
            hash += numbers[i] * (int) Math.pow(a, k - i - 1);
        }

        Set<Integer> hashes = new HashSet<>();
        hashes.add(hash);
        Set<String> duplicates = new HashSet<>();

        for (int i = k; i < numbers.length; i++) {
            hash = (hash - numbers[i-k] * (int) Math.pow(a, k - 1))*a + numbers[i];

            if (hashes.contains(hash)) {
                duplicates.add(s.substring(i-k+1, i+1));
            } else {
                hashes.add(hash);
            }
        }

       return duplicates;
    }

}
