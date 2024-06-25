package modified.binary.search;

import java.util.Random;

class RandomPickWithWeight {
    int sum = 0;
    int[] runningSum = new int[]{};
    Random random = new Random();

    public static void main(String[] args) {
        RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(new int[] {1, 12, 23, 34, 45, 56, 67, 78, 89, 90});

        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
        System.out.println(randomPickWithWeight.pickIndex());
    }

    public RandomPickWithWeight(int[] weights) {

        runningSum = new int[weights.length];

        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            runningSum[i] = sum;
        }
    }

    public int pickIndex() {

        int randomValue = random.ints(0, sum).findFirst().getAsInt();

        int left = 0;
        int right = runningSum.length-1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (runningSum[mid] > randomValue) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return left;
    }

    public static int sumW(int[] arr) {
        int sum = 0;
        // Loop through the array to calculate sum of elements
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    static float round(float var) {
        float value = (int) (var * 100 + .5);
        return (float) value / 100;
    }
}