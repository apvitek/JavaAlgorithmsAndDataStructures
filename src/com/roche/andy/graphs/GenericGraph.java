package com.roche.andy.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class GenericGraph<T extends Comparable<T>> {
    // Enum for the states used by the Depth first search
    public enum State {
        UNVISITED, VISITED
    }

    // vertex class
    private class Vertex {
        private T value;
        private ArrayList<Vertex> adjacencyList;
        private State state;

        Vertex(T v) {
            value = v;
            adjacencyList = new ArrayList<>();
            state = State.UNVISITED;
        }

        boolean isNotVisited() {
            return state != State.VISITED;
        }

        State getState() {
            return state;
        }
        void setState(State s) {
            state = s;
        }

        T getValue() {
            return value;
        }

        ArrayList<Vertex> getAdjacentList() {
            return adjacencyList;
        }

        void addNeighbor(Vertex n) {
            adjacencyList.add(n);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("Vertex: ").append(value).append(": ");

            for (Vertex each : adjacencyList) {
                stringBuilder.append(each.getValue()).append(" ");
            }

            return stringBuilder.toString();
        }
    }

    // edge class
    class Edge {
        private Vertex x, y;

        Edge(T v1, T v2) {
            x = findVertex(v1);

            if (x == null) {
                x = new Vertex(v1);
                vertexList.add(x);
            }

            y = findVertex(v2);

            if (y == null) {
                y = new Vertex(v2);
                vertexList.add(y);
            }

            x.addNeighbor(y);
            y.addNeighbor(x);
        }

        public String toString() {
            return "Edge X: " + x.getValue() + ", Y: " + y.getValue() + "\n";
        }
    }

    private ArrayList<Vertex> vertexList;
    private ArrayList<Edge> edgeList;

    GenericGraph() {
        vertexList = new ArrayList<>();
        edgeList = new ArrayList<>();
    }

    void addEdge(T x, T y) {
        Edge e = new Edge(x, y);
        edgeList.add(e);
    }

    private Vertex findVertex(T v) {
        for (Vertex each : vertexList) {
            if (each.getValue().compareTo(v) == 0) {
                return each;
            }
        }

        return null;
    }

    void DFS() {
        DFS(vertexList.get(0).value);
    }

    private void resetVisitedStatus() {
        for (Vertex aVertexList : vertexList) {
            aVertexList.setState(State.UNVISITED);
        }
    }

    void DFS(T initialElement) {
        resetVisitedStatus();

        if (vertexList.isEmpty()) {
            return;
        }

        Vertex vertexWithElement = findVertex(initialElement);

        if (vertexWithElement == null) {
            return;
        }

        DFS(vertexWithElement);
    }

    // Recurse through nodes
    private void DFS(Vertex vertex) {
        System.out.print(vertex.value + " ");

        vertex.setState(State.VISITED);

        // loop through neighbors
        for (Vertex current : vertex.getAdjacentList()) {
            if (current.isNotVisited()) {
                DFS(current);
            }
        }
    }

    void DFSUsingStack() {
        DFSUsingStack(vertexList.get(0).value);
    }

    void DFSUsingStack(T initialElement) {
        // Reset visited status
        resetVisitedStatus();

        if (vertexList.isEmpty()) {
            return;
        }

        Vertex vertexWithElement = findVertex(initialElement);

        if (vertexWithElement == null) {
            return;
        }

        // call recursive function
        DFSUsingStack(vertexWithElement);
    }

    private void DFSUsingStack(Vertex initialVertex) {
        // Create a stack for DFS
        Stack<Vertex> stack = new Stack<>();

        // Push the current source node
        stack.push(initialVertex);

        while (!stack.empty()) {
            // Pop a initialVertex from stack and print it
            Vertex nextVertex = stack.peek();
            stack.pop();

            if (nextVertex.isNotVisited()) {
                System.out.print(nextVertex.value + " ");
                nextVertex.setState(State.VISITED);

                // Get all adjacent vertices of the popped vertex. If a adjacent has not been visited, then push it
                // to the stack.
                for (Vertex v : nextVertex.getAdjacentList()) {
                    if (v.isNotVisited()) {
                        stack.push(v);
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Vertex each : vertexList) {
            stringBuilder.append(each.toString()).append("\n");
        }

        return stringBuilder.toString();
    }

    String edgesToString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Edge each : edgeList) {
            stringBuilder.append(each);
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