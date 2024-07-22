package challenge.yourself;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInArray {

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{12,8,7,3,5,2,3,9,8,10,1,1}));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            set.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            set.remove(nums[i]);
        }

        return new ArrayList<>(set);

    }
}
