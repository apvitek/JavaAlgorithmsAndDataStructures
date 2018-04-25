package com.roche.andy.graphs;

import java.util.ArrayList;
import java.util.Stack;

// Enum for the states used by the Depth first search
enum State {
    UNVISITED, VISITED
}

public class GenericGraph<T extends Comparable<T>> {
    private class Edge {
        private Vertex<T> x, y;

        Edge(Vertex<T> v1, Vertex<T> v2) {
            x = v1;
            y = v2;

            x.addNeighbor(y);
            y.addNeighbor(x);
        }

        public String toString() {
            return "Edge X: " + x.getValue() + ", Y: " + y.getValue() + "\n";
        }
    }

    private ArrayList<Vertex<T>> vertexList;
    private ArrayList<Edge> edgeList;

    public GenericGraph() {
        vertexList = new ArrayList<>();
        edgeList = new ArrayList<>();
    }

    public void addEdge(T x, T y) {
        Vertex<T> X = findVertex(x);

        if (X == null) {
            X = new Vertex<>(x);
            vertexList.add(X);
        }

        Vertex<T> Y = findVertex(y);

        if (Y == null) {
            Y = new Vertex<>(y);
            vertexList.add(Y);
        }

        Edge e = new Edge(X, Y);
        edgeList.add(e);
    }

    public Vertex<T> findVertex(T v) {
        for (Vertex<T> vertex : vertexList) {
            if (vertex.getValue().equals(v)) {
                return vertex;
            }
        }

        return null;
    }

    public void DFS() {
        DFS(vertexList.get(0).getValue());
    }

    public void resetVisitedStatus() {
        for (Vertex aVertexList : vertexList) {
            aVertexList.setState(State.UNVISITED);
        }
    }

    public void DFS(T initialElement) {
        resetVisitedStatus();

        if (vertexList.isEmpty()) {
            return;
        }

        Vertex<T> vertexWithElement = findVertex(initialElement);

        if (vertexWithElement == null) {
            return;
        }

        DFS(vertexWithElement);
    }

    private void DFS(Vertex<T> vertex) {
        System.out.print(vertex.getValue() + " ");

        vertex.setState(State.VISITED);

        // loop through neighbors
        for (Vertex<T> current : vertex.getAdjacentList()) {
            if (current.isNotVisited()) {
                DFS(current);
            }
        }
    }

    public void DFSUsingStack() {
        DFSUsingStack(vertexList.get(0).getValue());
    }

    public void DFSUsingStack(T initialElement) {
        // Reset visited status
        resetVisitedStatus();

        if (vertexList.isEmpty()) {
            return;
        }

        Vertex<T> vertexWithElement = findVertex(initialElement);

        if (vertexWithElement == null) {
            return;
        }

        DFSUsingStack(vertexWithElement);
    }

    private void DFSUsingStack(Vertex<T> initialVertex) {
        // Create a stack for DFS
        Stack<Vertex<T>> stack = new Stack<>();

        // Push the current source node
        stack.push(initialVertex);

        while (!stack.empty()) {
            // Pop a initialVertex from stack and print it
            Vertex<T> nextVertex = stack.peek();
            stack.pop();

            if (nextVertex.isNotVisited()) {
                System.out.print(nextVertex.getValue() + " ");
                nextVertex.setState(State.VISITED);

                // Get all adjacent vertices of the popped vertex.
                // If a adjacent has not been visited, then push it
                // to the stack.
                for (Vertex<T> current : nextVertex.getAdjacentList()) {
                    if (current.isNotVisited()) {
                        stack.push(current);
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Vertex vertex : vertexList) {
            stringBuilder.append(vertex.toString()).append("\n");
        }

        return stringBuilder.toString();
    }

    public String edgesToString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Edge edge : edgeList) {
            stringBuilder.append(edge);
        }

        return stringBuilder.toString();
    }
}

class DFSTest {
    public static void main(String args[]) {
        GenericGraph<Integer> graph = new GenericGraph<>();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println(graph);
        System.out.println(graph.edgesToString());

        System.out.println("\nDFS starting with 0 as the root:");

        graph.DFSUsingStack();
        System.out.println();
        graph.DFS();
        System.out.println();

        System.out.println("\nDFS starting with 2 as the root:");

        graph.DFSUsingStack(2);
        System.out.println();
        graph.DFS(2);
    }
}