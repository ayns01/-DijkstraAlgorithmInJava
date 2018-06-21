package com.ayn.dijkstra;

import java.util.*;

public class Dijkstra {
    ArrayList<Node> paths = new ArrayList<Node>();
    ArrayList<Node> visited = new ArrayList<Node>();

    public Dijkstra(Node[] paths, Node start) {
        for (Node path : paths) {
            this.paths.add(path);
        }
        DijkstraPath(start);
    }

    public void DijkstraPath(Node source) {
        source.pathCost = 0;

        Node n = source;
        int count = 0;
        while (count != 7) {
            for (Object key : n.adjacentNodes.keySet()) {
                Node currentNode = (Node) key;
                if (visited.contains(currentNode)) {
                    continue;
                }
                int newPathCost = n.pathCost + (int) n.adjacentNodes.get(currentNode);
                if (currentNode.pathCost > newPathCost) {
                    currentNode.pathCost = newPathCost;
                    currentNode.from = n;
                } else if (currentNode.pathCost < newPathCost) {

                }

            }
            this.paths.remove(n);
            this.visited.add(n);

            int min = Integer.MAX_VALUE;
            for(Node p: paths) {
                if(p.pathCost < min) {
                    min = p.pathCost;
                    n = p;
                }
            }
            count++;
        }

        System.out.println("Shortest path distance from source: " + source.name + " to distination: F");
        for(Node p: visited) {
            if(p.name.equals("F")) {
                System.out.print(p.name + "<==");
                while (!p.from.name.equals(source.name)) {
                    System.out.print(p.from.name);
                    p = p.from;
                }
            }
        }
        System.out.println("<==" + source.name);
    }
}