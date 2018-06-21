package com.ayn.dijkstra;

import java.util.*;

public class Node {

    String name = "";

    Map adjacentNodes = new HashMap();
    int pathCost = Integer.MAX_VALUE;
    Node from;

    public Node(String name) {
        this.name = name;
    }

    public void addAdjacentNodes(Node n, int dist) {
        this.adjacentNodes.put(n, dist);
    }
}