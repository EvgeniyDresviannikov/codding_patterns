package hash.maps;

import java.util.HashMap;

class FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();

        if (numerator == 0) return "0";

        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            sb.append("-");
        }

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);


        sb.append(num / den);
        long remainder = num % den;

        HashMap<Long, Integer> map = new HashMap<>();

        if (remainder == 0) {
            return sb.toString();
        } else {
            sb.append(".");
            while (remainder != 0) {
                if (map.containsKey(remainder)) {
                    sb.insert(map.get(remainder), "(");
                    sb.append(")");
                    break;
                }
                map.put(remainder, sb.length());
                remainder *= 10;
                sb.append(remainder / den);
                remainder = remainder % den;

            }
        }

        return sb.toString();



    }

    public static void main(String[] args) {
        int[][] inputs = {{ -1, -2147483648 } };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1 + ".\tInput: fraction_to_decimal(");
            for (int j = 0; j < inputs[i].length - 1; j++) {
                System.out.print(inputs[i][j]);
                System.out.print(", ");
            }
            System.out.println(inputs[i][inputs[i].length - 1] + ")");
            String result = fractionToDecimal(inputs[i][0], inputs[i][1]);
            System.out.println("\tOutput: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

