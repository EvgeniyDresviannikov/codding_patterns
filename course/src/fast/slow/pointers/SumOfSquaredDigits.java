package fast.slow.pointers;

public class SumOfSquaredDigits {

    public static void main(String[] args) {
        System.out.println(isHappyNumber(2));
    }

    public static boolean isHappyNumber(int n) {

        int slowPointer = n;
        int fastPointer = n;

        for (int i = 1; i < 1000; i++) {
            fastPointer = sumOfSquaredCalculate(fastPointer);
            if (i % 2 == 0) {
                slowPointer = sumOfSquaredCalculate(slowPointer);
            }
            if (fastPointer == 1) return true;
            if (fastPointer == slowPointer) return false;
        }


        return false;
    }

    private static int sumOfSquaredCalculate(int n) {
        int sum = (n % 10)*(n % 10);
        while (n/10 != 0) {
            n = n / 10;
            int rest = n % 10;
            sum += rest*rest;
        }
        System.out.println(sum);
        return sum;
    }
}
