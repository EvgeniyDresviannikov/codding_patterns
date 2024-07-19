package bitwise.manipulation;

public class FindDifference {

    public static void main(String[] args) {
        System.out.println(extraCharcterIndex("wxyz", "zwxgy"));
    }

    public static int extraCharcterIndex(String s, String t) {

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            res ^= t.charAt(i);
        }

        if (s.length() > t.length()) {
            return s.indexOf(res);
        } else {
            return t.indexOf(res);
        }

    }
}
