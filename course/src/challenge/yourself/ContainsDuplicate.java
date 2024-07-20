package challenge.yourself;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{ 1,3,6,2,3,5,4,8,7,6,2,3,5,2,9,4,3 }));
    }

    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                return true;
            }
            visited.add(nums[i]);
        }

        return false;
    }
}
