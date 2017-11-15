package com.spirit.high;

import java.util.Arrays;
import java.util.Collections;

public class RandomPairs {

    public static void main(String[] args) {
        String[] values = {"A", "B", "C", "D", "E", "F", "G", "H"};
        System.out.println(Arrays.deepToString(values));
        String[][] pickedValues = pick(values);
        System.out.println(Arrays.deepToString(pickedValues));
    }

    static String[][] pick(final String[] values) {
        Collections.shuffle(Arrays.asList(values));
        final String[] duplicates = Arrays.copyOf(values, values.length);
        for (int i=0; i<values.length; i++) {
            if(values[i].equals(duplicates[i])) {
                Collections.shuffle(Arrays.asList(duplicates));
                i = -1;
            }
        }
        String[][] returnArray = new String[values.length][2];
        for (int j=0; j<returnArray.length; j++) {
            returnArray[j][0] = values[j];
            returnArray[j][1] = duplicates[j];
        }
        return returnArray;
    }

}
