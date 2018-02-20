package edu.bicheva.codewars;

import java.util.regex.Pattern;

/**
 * @author Yulia Bycheva
 **/
public class BraceChecker {

    public static void main(String[] args) {
        boolean a = isValid("][][");
        System.out.println(a);
    }

    public static boolean isValid(String str) {
        return isValid(str.toCharArray(), 0, str.length());
    }

    public static boolean isValid(char[] brackets, int start, int end) {
        if(brackets.length % 2 != 0) return false;

        int index = start;
        while(index < end) {
            char item = brackets[index];
            if(isOpen(item)) {
                int closeIndex = obtainCloseIndex(index + 1, getCloseBracket(brackets[index]), brackets);
                if (closeIndex == -1) {
                    return false;
                }

                index = closeIndex + 1;
            } else
                return false;
        }
        return true;
    }

    private static int obtainCloseIndex(int start, char closeItem, char[] brackets) {
        int count = 0;
        for (int i = start; i < brackets.length; i++) {
            char item = brackets[i];
            if(isOpen(item))
                count++;
            else {
                if (item == closeItem && count == 0 && isValid(brackets, start, i)){
                    return i;
                }
                count--;
            }
        }
        return -1;
    }

    private static boolean isOpen(char bracket) {
        return bracket == '(' || bracket == '[' || bracket == '{';
    }

    private static char getCloseBracket(char openItem) {
        switch (openItem) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
            default:
                return ' ';
        }
    }
}
