package edu.bicheva.codewars.compiler;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Yulia Bycheva
 **/
public class Compiler {
    public List<String> compile(String prog) {
        return pass3(pass2(pass1(prog)));
    }

    /**
     * Returns an un-optimized AST
     */
    public Ast pass1(String prog) {
        Deque<String> tokens = tokenize(prog);
        System.out.println(tokens);

        Iterator<String> iterator = tokens.iterator();
        List<String> argsList = new ArrayList<>();
        Ast ast = null;

        while (tokens.size() > 0) {
            String element = tokens.element();
            switch (element) {
//                case "$":
//                    break;
                case "[":
                    System.out.println(element);
                    tokens.remove();
                    while(tokens.size() > 0) {
                        element  = tokens.element();
                        System.out.println(element);
                        if("]".equals(element))
                            break;

                        argsList.add(element);
                        tokens.remove();
                    }
                    break;
//                case "(":
//                    makeExpression(iterator, argsList);
//                    break;
//                case ")":
//                    break;
//                case "*":
//                case "/":
//                case "+":
//                case "-":
//                    break;
                default:
                    ast = parseExpression(tokens, argsList);
                    break;
            }

            if (tokens.size()>0)
                tokens.remove();
        }

        return ast;
    }

    private Ast parseExpression(Deque<String> tokens, List<String> argsList) {
        Ast prev = null;
        while (tokens.size() > 0) {
            String element = tokens.element();
            System.out.println(element);

            if("$".equals(element))
                tokens.remove();

            if(")".equals(element)) {
                tokens.remove();
                return prev;
            }

            if(element.equals("+") || element.equals("-")) {
                tokens.remove();
                prev = new BinOp(element, prev, parseTerm(tokens, argsList, null));
            } else {
                prev = parseTerm(tokens, argsList, prev);
            }


        }
        return prev;
    }

    private Ast parseTerm(Deque<String> tokens, List<String> argsList, Ast previous) {
        Ast prev = previous;
        if(tokens.size() > 0) {
            String element = tokens.element();
            if(prev == null) {
                if (element.matches("[a-zA-Z]+") || element.matches("\\d+") || element.equals("(")) {
                    prev = parseFactor(tokens, argsList);
                }
            }
            if (element.matches("[a-zA-Z]+") || element.matches("\\d+") || element.equals("(")) {
                prev = parseFactor(tokens, argsList);
            } else if(element.equals("*") || element.equals("/")) {
                tokens.remove();
                prev = new BinOp(element, prev, parseFactor(tokens, argsList));
            }
        }

        return prev;
    }

    private Ast parseFactor(Deque<String> tokens, List<String> argsList) {
        Ast factor = null;
        if(tokens.size() > 0) {
            String element = tokens.element();
            if (element.matches("[a-zA-Z]+")) {
                factor = new UnOp("arg", parseArgs(element, argsList));
                tokens.remove();
            } else if (element.matches("\\d+")) {
                factor = new UnOp("imm", Integer.valueOf(element));
                tokens.remove();
            } else if (element.equals("(")) {
                tokens.remove();
                factor = parseExpression(tokens, argsList);
            }
        }

        return factor;
    }

    private int parseArgs(String element, List<String> argsList) {
        return argsList.indexOf(element);
    }

    /**
     * Returns an AST with constant expressions reduced
     */
    public Ast pass2(Ast ast) {
        if(ast instanceof BinOp) {
            BinOp op = (BinOp) ast;
            Ast a = op.a();
            Ast b = op.b();

            int res1 = 0;
            if(a instanceof UnOp) {
                UnOp a1 = (UnOp) a;
                if(a1.op().equals("imm")) {
                    res1 = a1.n();
                }
            }
        }

        return null;
    }

    /**
     * Returns assembly instructions
     */
    public List<String> pass3(Ast ast) {
        return null;
    }

    private static Deque<String> tokenize(String prog) {
        Deque<String> tokens = new LinkedList<>();
        Pattern pattern = Pattern.compile("[-+*/()\\[\\]]|[a-zA-Z]+|\\d+");
        Matcher m = pattern.matcher(prog);
        while (m.find()) {
            tokens.add(m.group());
        }
        tokens.add("$"); // end-of-stream
        return tokens;
    }
}
