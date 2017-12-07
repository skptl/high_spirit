package com.spirit.high;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parenthesis {

    private static String INVALID_INPUT = "$INVALID$";

    public static void main(String[] args) {
        String[] tests = {
                "(a+b)((a+b)",
                "((a+b)((a+b)",
                "(a+b)((a+b)))",
                "(a+b)(a+b((a+b)",
                "))))))))))((((((((((",
                "(((((((((((a))))))))))",
                null,
                ""
        };
        for(String input : tests) {
            System.out.println(String.format("%s -> %s\n", input, removeUnbalanced(input)));
        }
    }

    static String removeUnbalanced(String input) {

        if (input == null || input.length() == 0) return INVALID_INPUT;

        Deque<Character> brackets = new ArrayDeque<>();
        Deque<Integer> indexes = new ArrayDeque<>();

        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if ('(' == currentChar) {
                brackets.push(currentChar);
                indexes.push(i);
            } else if (')' == currentChar) {
                char stackTop = brackets.peek() != null ? brackets.peek() : ' ';
                if ('(' == stackTop) {
                    brackets.pop();
                    indexes.pop();
                } else {
                    brackets.push(currentChar);
                    indexes.push(i);
                }
            }
        }

        if (indexes.size() == 0) return input;

        if (indexes.size() == chars.length) return INVALID_INPUT;

        StringBuilder builder = new StringBuilder(input);
        while (!indexes.isEmpty()) {
            builder.deleteCharAt(indexes.pop());
        }
        return builder.toString();

    }

}
