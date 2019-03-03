package com.spirit.high;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AvgComponent {

    public static HashMap<NodeComponent, int[]> map = new HashMap<>();
    public static float highestAverage = 0;
    public static NodeComponent ansNode = new NodeComponent(-1);

    public static void main(String[] args) throws IOException {
        NodeComponent n1 = new NodeComponent(1);
        NodeComponent n2 = new NodeComponent(0);
        NodeComponent n3 = new NodeComponent(2);
        NodeComponent n4 = new NodeComponent(3);
        n1.components.add(n2);
        n1.components.add(n3);
        n1.components.add(n1);
        n3.components.add(n4);
        n3.components.add(n3);
        getAverage(n1);
        System.out.println(" AnsNode " + ansNode.value);
    }

    public static NodeComponent getAverage(NodeComponent root){

        if (root.components.size() == 0){
            int[] temp = new int[]{root.value, 1};
            map.put(root,temp);
            return root;
        }
        for (NodeComponent node : root.components){
            if (node == root){
                break;
            }
            getAverage(node);
        }
        float average = calAverage(root);
        if (average > highestAverage){
            highestAverage = average;
            ansNode = root;
        }
        System.out.println("root " + root.value + " average " + average);
        return root;
    }

    public static float calAverage(NodeComponent node){
        int count = 0;
        float avg;
        int sum = 0;
        for (NodeComponent nodeComponent : node.components){
            if (map.containsKey(nodeComponent)){
                    sum += map.get(nodeComponent)[0];
                    count += map.get(nodeComponent)[1];
            }
            else {
                sum += nodeComponent.value;
                count ++;
            }
            System.out.println("nodeComponent " + node.value + " componentValue " + nodeComponent.value + " sum " + sum + " count" + count);
        }
        int[] temp = new int[]{sum, count};
        map.put(node,temp);
        avg = (float) sum / count;
        return avg;
    }

    static class NodeComponent {

        int value;
        ArrayList<NodeComponent> components;

        NodeComponent(){
            components = new ArrayList<>();
        }

        NodeComponent(int value) {
            this.value = value;
            components = new ArrayList<>();
        }
    }

}
