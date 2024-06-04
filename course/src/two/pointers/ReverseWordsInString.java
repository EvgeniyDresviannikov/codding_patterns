package two.pointers;

public class ReverseWordsInString {

    public static void main(String[] args) {
        System.out.println(reverseWords("Reverse  the words   in a sentence"));
    }

    public static String reverseWords(String sentence) {

        sentence = sentence.trim();
        sentence = sentence.replaceAll("\\s+", " ");

        char[] str = sentence.toCharArray();

        strRev(str, 0, str.length-1);


        int right = 0;
        int left = 0;
        while(right <= str.length-1) {
            if (right == str.length-1 || str[right] == ' ') {
                int endIdx = (right == str.length-1 ) ? right : right - 1;
                strRev(str, left, endIdx);
                left = right+1;
            }
            right++;
        }

        return new String(str);
    }

    private static void strRev(char[] str, int left, int right) {
        while (left < right) {
            char tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            left++;
            right--;
        }
    }
}
