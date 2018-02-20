package edu.bicheva.codewars;

import org.junit.Test;

import static edu.bicheva.codewars.BraceChecker.isValid;
import static org.junit.Assert.*;

/**
 * @author Yulia Bycheva
 **/
public class BraceCheckerTest {

    @Test
    public void test1() {
        assertEquals(true, isValid("(){}[]"));
    }

    @Test
    public void test2() {
        assertEquals(true, isValid("([{}])"));
    }

    @Test
    public void test3() {
        assertEquals(false, isValid("{)"));
    }

    @Test
    public void test4() {
        assertEquals(false, isValid("[(])"));
    }

    @Test
    public void test5() {
        assertEquals(false, isValid("{][[]{}}()"));
    }

    @Test
    public void test6() {
        assertEquals(false, isValid("[({})](]"));
    }

    @Test
    public void test7() {
        assertEquals(true, isValid("{[()()]}([{}]){}"));
    }

    @Test
    public void test8() {
        assertEquals(false, isValid("][]["));
    }

    @Test
    public void test9() {
        assertEquals(true, isValid("{[[{}][]]}([]{}){}"));
    }

    @Test
    public void test10() {
        assertEquals(false, isValid("(({{[[]]}}))({{[[]]}}"));
    }




}