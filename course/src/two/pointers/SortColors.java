package two.pointers;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortColors(new int[]{0,1,0})));
                                                                // 0 0 0 0 1 1 1 1 1 2 2 2
    }

    public static int[] sortColors (int[] colors) {
        int start = 0;
        int current = 0;
        int end = colors.length-1;
        int temp = 0;
        while (current <= end) {
            if (colors[current] == 0) {
                temp = colors[start];
                colors[start] = colors[current];
                colors[current] = temp;
                start++;
                current++;
            } else if (colors[current] == 1) {
                current++;

            } else {
                temp = colors[end];
                colors[end] = colors[current];
                colors[current] = temp;
                end--;
            }

        }

        return colors;
    }
}
