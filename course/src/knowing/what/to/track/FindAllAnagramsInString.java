package knowing.what.to.track;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInString {

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        HashMap<Character, Integer> hashA = new HashMap<>();
        HashMap<Character, Integer> hashB = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            hashB.put(c, hashB.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i > p.length()-1) {
                char charForRemove = s.charAt(i - p.length());
                hashA.put(charForRemove, hashA.get(charForRemove)-1);
                if (hashA.get(charForRemove) == 0) {
                    hashA.remove(charForRemove);
                }
            }
            hashA.put(c, hashA.getOrDefault(c, 0) + 1);
            if (hashA.equals(hashB)) {
                res.add(i - p.length()+1);
            }
        }


        return res;
    }
}
