package com.spirit.high;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MorganAndString {

    private static String morganAndString(String a, String b) {
        StringBuilder resultBuilder = new StringBuilder();
        int aPointer = 0, bPointer = 0, aCurrent, bCurrent, limit, counter, similarCounter;
        int totalSize = a.length() + b.length();
        a += "|";
        b += "|";
        while (resultBuilder.length() < totalSize) {
            if (a.charAt(aPointer) < b.charAt(bPointer)) {
                resultBuilder.append(a.charAt(aPointer++));
            } else if (a.charAt(aPointer) > b.charAt(bPointer)) {
                resultBuilder.append(b.charAt(bPointer++));
            } else {
                limit = Math.min(a.length() - aPointer, b.length() - bPointer);
                counter = similarCounter = 1;
                boolean skip = false;
                while (counter < limit) {
                    aCurrent = counter + aPointer;
                    bCurrent = counter + bPointer;
                    if (a.charAt(aCurrent) != b.charAt(bCurrent)) {
                        if (a.charAt(aCurrent) < b.charAt(bCurrent)) {
                            while (similarCounter-- > 0) {
                                resultBuilder.append(a.charAt(aPointer++));
                            }
                        } else {
                            while (similarCounter-- > 0) {
                                resultBuilder.append(b.charAt(bPointer++));
                            }
                        }
                        skip = true;
                        break;
                    }
                    if (a.charAt(aCurrent - 1) == a.charAt(aCurrent)) {
                        similarCounter++;
                    }
                    counter++;
                }
                if (!skip) {
                    if (a.length() - aPointer - b.length() + bPointer < 0) {
                        resultBuilder.append(a.charAt(aPointer++));
                    } else {
                        resultBuilder.append(b.charAt(bPointer++));
                    }
                }
            }
        }
        return resultBuilder.toString();
    }

    private static final String PATH = "";
    private static final String INPUT = PATH + "input13.txt";
    private static final String OUTPUT = PATH + "output13.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new FileReader(INPUT));
        BufferedReader outputReader = new BufferedReader(new FileReader(OUTPUT));
        int t = Integer.parseInt(inputReader.readLine());
        for (int tItr = 0; tItr < t; tItr++) {
            String a = inputReader.readLine().trim();
            String b = inputReader.readLine().trim();
            String expectedResult = outputReader.readLine().trim();
            String result = morganAndString(a, b).trim();
            if (result.compareTo(expectedResult) != 0) {
                int limit = Math.min(result.length(), expectedResult.length());
                for (int i = 0; i < limit; i++) {
                    if (result.charAt(i) != expectedResult.charAt(i)) {
                        System.out.println("Different from: " + i);
                        break;
                    }
                }
                throw new IllegalStateException("This is not working!");
            }
        }
        outputReader.close();
        inputReader.close();
    }
}
