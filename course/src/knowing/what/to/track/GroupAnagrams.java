package knowing.what.to.track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"bat", "tab", "tan", "at"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        int shift = 97;
        HashMap<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int[] key = new int[26];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                int idx = (int)c - shift;
                key[idx] += 1;
            }
            if (map.containsKey(Arrays.hashCode(key))) {
                map.get(Arrays.hashCode(key)).add(str);
            } else {
                List<String> lst = new ArrayList<>();
                lst.add(str);
                map.put(Arrays.hashCode(key), lst);
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }
}
