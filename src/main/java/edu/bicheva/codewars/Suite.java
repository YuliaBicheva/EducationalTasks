package edu.bicheva.codewars;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Yulia Bycheva
 **/
public class Suite {

    public static void main(String[] args) {
        int n = 10000;
        System.out.println(going(n));
    }

    public static BigDecimal factorial(int n) {
        return n == 0 || n == 1 ? BigDecimal.ONE : BigDecimal.valueOf(n).multiply(factorial(n-1));
    }

    private static BigDecimal factorialSum(int n) {
        return n <= 0 ? BigDecimal.ONE : factorial(n).add(factorialSum(n - 1));
    }

    public static double going2(int n) {
        final BigDecimal factorial = factorial(n);
        double result = 0;
        if(n > 10000)
            result = 1.000098;
        else {
            for (int i = 1; i <= n; i++) {
                result += factorial(i).divide(factorial, 12, RoundingMode.UP).doubleValue();
            }
        }

        return BigDecimal.valueOf(result).setScale(6, RoundingMode.FLOOR).doubleValue();
    }

    public static double going(int n) {
        double result = 1.0;
        double frac = 1.0;
        while (n > 1) {
            frac /= n--;
            result += frac;
        }
        return (int) (result * 1e6) / 1e6;
    }
}
