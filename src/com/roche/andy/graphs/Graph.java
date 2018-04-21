package com.roche.andy.graphs;

import java.util.LinkedList;

// This class represents a directed graph using adjacency list representation
@SuppressWarnings("unchecked")
class Graph {
    private int numberOfVertexes;   // No. of vertices
    private LinkedList<Integer> adjacencyLists[]; // Adjacency Lists

    // Constructor
    Graph(int v) {
        numberOfVertexes = v;
        adjacencyLists = new LinkedList[v];

        for (int i = 0; i < v; ++i)
            adjacencyLists[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adjacencyLists[v].add(w);
    }

    int getNumberOfVertexes() {
        return numberOfVertexes;
    }

    LinkedList<Integer>[] getAdjacencyLists() {
        return adjacencyLists;
    }
}
