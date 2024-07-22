package challenge.yourself;

public class LemonadeChange {

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,5,5,20,10,10}));
    }

    public static boolean lemonadeChange(int[] bill) {

        int fifths = 0;
        int tens = 0;

        for (int i = 0; i < bill.length; i++) {
            int value = bill[i];
            if (value == 5) {
                fifths++;
            } else if (value == 10) {
                if (fifths > 0) {
                    fifths--;
                    tens++;
                } else {
                    return false;
                }
            } else if (value == 20) {
                if (tens > 0 && fifths > 0) {
                    tens--;
                    fifths--;
                } else if (fifths >= 3) {
                    fifths -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
