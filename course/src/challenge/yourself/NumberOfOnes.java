package challenge.yourself;

public class NumberOfOnes {

    public static void main(String[] args) {
        System.out.println(numberOf1Bits(9));
    }

    public static int numberOf1Bits(int n){
        int cnt = 0;
        int mask=1;

        for (int i = 0; i < 32; i++) {
            if ( (mask&n) != 0) {
                cnt++;
            }
            mask<<=1;
        }

        return cnt;
    }
}
