package two.pointers;

public class ValidPalindrom2 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("abceba"));
    }

    public static boolean isPalindrome(String s) {
        boolean mismatchOccured = false;

        int left = 0;
        int right = s.length()-1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                mismatchOccured = true;
                break;
            } else {
                left++;
                right--;
            }
        }

        if (!mismatchOccured) return true;

        if (isRealPalindrom(s, left+1, right)) return true;

        if (isRealPalindrom(s, left, right-1)) return true;

        return false;


    }

    private static boolean isRealPalindrom(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }
}
