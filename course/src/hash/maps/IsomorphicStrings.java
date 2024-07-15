package hash.maps;

import java.util.HashMap;

public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("dida", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c1) && map1.get(c1) != c2) {
                return false;
            } else {
                map1.put(c1, c2);
            }

            if (map2.containsKey(c2) && map2.get(c2) != c1) {
                return false;
            } else {
                map2.put(c2, c1);
            }
        }

        return true;
    }
}
