package sliding.window;

public class MinimumWindowSubsequence {

    public static void main(String[] args) {
        System.out.println(minWindow("abcdedeaqdweq", "adeq"));
    }

    public static String minWindow(String s, String t) {

        int right = 0;
        String minSubs = "";
        int tCurrIndex = 0;
        int tStartIndex = 0;
        while(right < s.length()) {
            if (s.charAt(right) == t.charAt(tCurrIndex)) {
                if (tCurrIndex == 0) {
                    tStartIndex = right;
                }

                tCurrIndex++;

                if (tCurrIndex == t.length()) {
                    String subs = s.substring(tStartIndex, right+1);
                    minSubs = minSubs.isEmpty() || minSubs.length() > subs.length() ? subs : minSubs;
                    right = tStartIndex+1;
                    tCurrIndex = 0;
                    continue;
                }
            }
            right++;
        }

        return minSubs;
    }
}
