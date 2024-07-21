package challenge.yourself;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {0,-1,2,-3,4,-2})));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        int[] res = new int[nums.length];

        int tmp = 1;
        for (int i = 0; i < nums.length; i++) {
            tmp *= nums[i];
            prefix[i] = tmp;
        }

        tmp = 1;
        for (int i = nums.length-1; i > -1; i--) {
            tmp *= nums[i];
            postfix[i] = tmp;
        }

        res[0] = postfix[1];
        res[res.length-1] = prefix[res.length-2];
        for (int i = 1; i < res.length-1; i++) {
            res[i] = prefix[i-1]*postfix[i+1];
        }

        return res;
    }
}
