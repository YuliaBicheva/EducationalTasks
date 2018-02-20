package edu.bicheva.codewars;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static edu.bicheva.codewars.Suite.factorial;
import static org.junit.Assert.*;

/**
 * @author Yulia Bycheva
 **/
public class SuiteTest {

    @Test
    public void testFactorial() {
        BigDecimal result = factorial(20);
        Assert.assertEquals(BigDecimal.valueOf(2432902008176640000L), result);
        System.out.println(result.toString());
    }

    public static final double DELTA = 1e-10;

    @Test
    public void test1() {
        assertEquals(1.275, Suite.going(5), DELTA);
    }
    @Test
    public void test2() {
        assertEquals(1.2125, Suite.going(6), DELTA);
    }
    @Test
    public void test3() {
        assertEquals(1.173214, Suite.going(7), DELTA);
    }
    @Test
    public void test4() {
        assertEquals(1.146651, Suite.going(8), DELTA);
    }
    @Test
    public void test5() {
        assertEquals(1.034525, Suite.going(30), DELTA);
    }
    @Test
    public void test6() {
        assertEquals(1.052786, Suite.going(20), DELTA);
    }
    @Test
    public void test7() {
        assertEquals(1.020416, Suite.going(50), DELTA);
    }
    @Test
    public void test8() {
        assertEquals(1.008929, Suite.going(113), DELTA);
    }
    @Test
    public void test9() {
        assertEquals(1.005025, Suite.going(200), DELTA);
    }
    @Test
    public void test10() {
        assertEquals(1.052786, Suite.going(20), DELTA);
    }
    @Test
    public void test11() {
        assertEquals(1.00099, Suite.going(1011), DELTA);
    }
    @Test
    public void test12() {
        assertEquals(1.000098, Suite.going(10110), DELTA);
    }

}