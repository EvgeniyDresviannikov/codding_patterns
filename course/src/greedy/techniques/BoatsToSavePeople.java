package greedy.techniques;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        System.out.println(rescueBoats(new int[]{3,1,4,2,4}, 4)); // 1 2 3 4 4
    }

    public static int rescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int left = 0;
        int right = people.length-1;
        int counter = 0;


        while (left < right) {
            if (people[right] + people[left] <= limit) {
                left++;
            }
            right--;
            counter++;
        }

        if (left == right) counter++;

        return counter;
    }
}
