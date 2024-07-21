package challenge.yourself;

public class SumOfTwoIntegers {

    public static void main(String[] args) {
        System.out.println(integerAddition(9, 11));
    }

    public static int integerAddition(int a, int b) {

        while (b != 0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }
        return a;
    }
}
