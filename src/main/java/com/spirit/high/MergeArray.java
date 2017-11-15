package com.spirit.high;

import java.util.Arrays;

public class MergeArray {

    private static final int[] ARRAY_ONE = {0, 2, 4, 6, 8, 9, 11, 22};
    private static final int[] ARRAY_TWO = {1, 3, 5, 7};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ARRAY_ONE));
        System.out.println(Arrays.toString(ARRAY_TWO));
        merge(ARRAY_ONE, ARRAY_TWO);
        System.out.println(Arrays.toString(ARRAY_ONE));
        System.out.println(Arrays.toString(ARRAY_TWO));
    }

    private static void merge(int[] arrayOne, int[] arrayTwo) {
        int arrayOneSize = arrayOne.length - 1;
        int arrayTwoSize = arrayTwo.length - 1;
        for (int i=arrayTwoSize; i>=0; i--)
        {
            int j, last = arrayOne[arrayOneSize];
            for (j=arrayOneSize-1; j >= 0 && arrayOne[j] > arrayTwo[i]; j--)
                arrayOne[j+1] = arrayOne[j];
            if (j != arrayOneSize-1 || last > arrayTwo[i])
            {
                arrayOne[j+1] = arrayTwo[i];
                arrayTwo[i] = last;
            }
        }
    }

}
