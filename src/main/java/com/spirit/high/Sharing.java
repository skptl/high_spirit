package com.spirit.high;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Sharing {

    static class Coordinate {

        final int x, y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("  %d%d ", x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null)
                return false;
            if (o instanceof Coordinate) {
                Coordinate c = (Coordinate) o;
                return c.x == x && c.y == y;
            }
            return false;
        }
    }

    static class Pair implements Comparable<Pair> {

        Coordinate a;
        Coordinate b;

        Pair(Coordinate a, Coordinate b) {
            this.a = a;
            this.b = b;
        }

        int distance() {
            return Math.abs(a.x - b.x) + Math.abs(a.y - b.y) ;
        }

        @Override
        public String toString() {
            return String.format("a%d%d-b%d%d-%d", a.x, a.y, b.x, b.y, distance());
        }

        @Override
        public int compareTo(@NotNull Pair pair) {
            return Integer.compare(distance(), pair.distance());
        }
    }

    private static Set<Coordinate> A = new HashSet<>();
    private static Set<Coordinate> B = new HashSet<>();

    public static void main(String[] args) {
        // add as' to coordinates
        A.add(new Coordinate(0, 0));
        A.add(new Coordinate(1, 1));
        A.add(new Coordinate(3, 1));
        A.add(new Coordinate(3, 3));
        // add bs'
        B.add(new Coordinate(0, 3));
        B.add(new Coordinate(1, 3));
        B.add(new Coordinate(3, 0));
        B.add(new Coordinate(3, 2));
        // calculate
        getShortestDistancePairs();
    }

    static List<Pair> getShortestDistancePairs() {
        PriorityQueue<Pair> minimumDistanceHeap = new PriorityQueue<>();
        for (Coordinate a : A) {
            List<Pair> pairs = new ArrayList<>();
            for (Coordinate b : B) {
                Pair pair = new Pair(a, b);
                pairs.add(pair);
            }
            minimumDistanceHeap.addAll(pairs);
        }
        List<Pair> pairs = new ArrayList<>();
        Set<Coordinate> aWithB = new HashSet<>();
        Set<Coordinate> takenB = new HashSet<>();
        while (!minimumDistanceHeap.isEmpty()) {
            Pair pair = minimumDistanceHeap.poll();
            if (!takenB.contains(pair.b) && !aWithB.contains(pair.a)) {
                takenB.add(pair.b);
                aWithB.add(pair.a);
                pairs.add(pair);
            }
        }
        System.out.print(Arrays.deepToString(pairs.toArray()));
        return Collections.emptyList();
    }

}
