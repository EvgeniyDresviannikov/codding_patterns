package challenge.yourself;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("baabaad"));
    }

    public static String longestPalindromicSubstring(String s) {

        String res = "";

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;


            while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (res.length() < right - left - 1) {
                res = s.substring(left+1, right);
            }

            left = i;
            right = i+1;
            while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (res.length() < right - left - 1) {
                res = s.substring(left+1, right);
            }

        }

        return res;
    }
}
