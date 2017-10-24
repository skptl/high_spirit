package com.spirit.high;

import java.util.Arrays;
import java.util.List;

public class MatchCart {

    public static void main(String[] args) {
        List<String> patternOne = Arrays.asList("orange", "banana");
        List<String> patternTwo = Arrays.asList("orange", "anything", "banana");
        List<String> patternThree = Arrays.asList("apple", "banana");
        List<String> patternFour = Arrays.asList("kiwi", "anything", "apple");
        List<List<String>> patterns = Arrays.asList(patternOne, patternTwo, patternThree, patternFour);
        List<String> cart = Arrays.asList("kiwi", "orange", "banana", "apple", "orange", "orange", "banana", "orange", "apple", "banana", "kiwi", "kiwi", "kiwi", "kiwi", "apple");
        int matches = applyPattern(patterns, cart);
        System.out.println(matches);
    }

    public static int applyPattern(List<List<String>> patterns, List<String> cart) {
        int position = 0;
        for (List<String> pattern : patterns) {
            int matchCounter = 0, patternIndex = 0;
            for ( int counter = position; counter < cart.size() && patternIndex < pattern.size(); counter++, patternIndex = counter - position) {
                String patternString = pattern.get(patternIndex);
                String cartString = cart.get(counter);
                if (patternString.equals(cartString) || patternString.equals("anything"))
                    matchCounter++;
                else
                    position++;
            }
            if (pattern.size() != matchCounter) {
                return 0;
            }
            position += pattern.size();
        }
        return 1;
    }

}
