package com.spirit.high;

import java.util.*;

public class TreeOperation {

    static class Node {

        final String value;
        final List<Node> children;

        Node(String value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }

    static class Tree {

        final Node root;

        Tree() {
            root = new Node("R");
        }

        void print() {
            Deque<Node> nodeStack = new ArrayDeque<>();
            Deque<Integer> levelStack = new ArrayDeque<>();
            nodeStack.add(root);
            levelStack.add(0);
            while (!nodeStack.isEmpty()) {
                Node currentNode = nodeStack.pop();
                int currentLevel = levelStack.pop();
                if (!currentNode.children.isEmpty()) {
                    int children = currentNode.children.size() - 1;
                    for (int i = 0; i <= children; i++) {
                        nodeStack.push(currentNode.children.get(i));
                        levelStack.push(currentLevel + 1);
                    }
                }
                StringBuilder builder = new StringBuilder();
                builder.append('*');
                for (int i = 0; i < currentLevel; i++) {
                    builder.append('-');
                }
                builder.append(currentNode.value);
                System.out.println(builder.toString());
            }
        }
    }
    
    public static void main(String[] args) {

        List<Node> rootChildren = Arrays.asList(
                new Node("A"),
                new Node("B"));

        List<Node> aChildren = Arrays.asList(
                new Node("A1"),
                new Node("A2"));

        List<Node> bChildren = Arrays.asList(
                new Node("B1"),
                new Node("B2"));

        List<Node> a1Children = Arrays.asList(
                new Node("A11"),
                new Node("A12"));

        List<Node> a2Children = Arrays.asList(
                new Node("A21"),
                new Node("A22"));

        List<Node> b1Children = Arrays.asList(
                new Node("B11"),
                new Node("B12"));

        List<Node> b2Children = Arrays.asList(
                new Node("B21"),
                new Node("B22"));

        Tree tree = new Tree();

        tree.root.children.addAll(rootChildren);

        tree.root.children.get(0).children.addAll(aChildren);
        tree.root.children.get(1).children.addAll(bChildren);

        tree.root.children.get(0).children.get(0).children.addAll(a1Children);
        tree.root.children.get(0).children.get(1).children.addAll(a2Children);
        tree.root.children.get(1).children.get(0).children.addAll(b1Children);
        tree.root.children.get(1).children.get(1).children.addAll(b2Children);
        
        tree.print();
    }

}
