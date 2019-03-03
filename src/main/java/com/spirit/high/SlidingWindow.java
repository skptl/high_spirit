package com.spirit.high;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindow {

    public static void main(String[] args) {
        int[] array = { 1, 2, 100, 2, 2 };
        int windowSize = 2;
        float allowedGrowth = 1.5F;
        System.out.println(alert(array, windowSize, allowedGrowth));
    }

    private static boolean alert(int[] array, int windowSize, float allowedGrowth) {
        if (array == null ||
                array.length == 0 ||
                allowedGrowth == 0.0D ||
                array.length < windowSize) {
            return false;
        }
        PriorityQueue<Integer> windowQueue = new PriorityQueue<>(windowSize, Comparator.reverseOrder());
        float previousAllowed = 0.0F;
        int numberOfWindows = array.length - windowSize + 1;
        for (int i = 0; i < numberOfWindows; i++) {
            float currentSum = 0.0F;
            for (int j = i; j < i + windowSize; j++) {
                windowQueue.offer(array[j]);
                currentSum = currentSum + array[j];
            }
            float currentAverage = currentSum / windowSize;
            float currentAllowed = currentAverage * allowedGrowth;
            if (!windowQueue.isEmpty() && windowQueue.peek() > currentAllowed ||
                    (i != 0 && currentAverage > previousAllowed)) {
                return true;
            }
            windowQueue.clear();
            if (previousAllowed < currentAllowed) {
                previousAllowed = currentAllowed;
            }
        }
        return false;

    }
}
