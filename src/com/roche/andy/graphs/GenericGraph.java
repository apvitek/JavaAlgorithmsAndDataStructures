package com.roche.andy.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class GenericGraph<T extends Comparable<T>> {
    // Enum for the states used by the Depth first search
    public enum State {
        UNVISITED, VISITED
    }

    // Vertex class
    public class Vertex {
        private T value;
        private ArrayList<Vertex> adjacencyList;
        private State state;

        public Vertex(T v) {
            value = v;
            adjacencyList = new ArrayList<>();
            state = State.UNVISITED;
        }

        public boolean isNotVisited() {
            return state != State.VISITED;
        }

        public State getState() {
            return state;
        }

        public void setState(State s) {
            state = s;
        }

        public void setVisited() {
            state = State.VISITED;
        }

        public T getValue() {
            return value;
        }

        public ArrayList<Vertex> getAdjacentList() {
            return adjacencyList;
        }

        public void addNeighbor(Vertex n) {
            adjacencyList.add(n);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("Vertex: ").append(value).append(": ");

            for (Vertex vertex : adjacencyList) {
                stringBuilder.append(vertex.getValue()).append(" ");
            }

            return stringBuilder.toString();
        }
    }

    // Edge class
    public class Edge {
        private Vertex x, y;

        public Edge(T v1, T v2) {
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

    public GenericGraph() {
        vertexList = new ArrayList<>();
        edgeList = new ArrayList<>();
    }

    public void addEdge(T x, T y) {
        Edge e = new Edge(x, y);
        edgeList.add(e);
    }

    public Vertex findVertex(T v) {
        for (Vertex vertex : vertexList) {
            if (vertex.getValue().compareTo(v) == 0) {
                return vertex;
            }
        }

        return null;
    }

    public void DFS() {
        DFS(vertexList.get(0).value);
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

        Vertex vertexWithElement = findVertex(initialElement);

        if (vertexWithElement == null) {
            return;
        }

        DFS(vertexWithElement);
    }

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

    public void DFSUsingStack() {
        DFSUsingStack(vertexList.get(0).value);
    }

    public void DFSUsingStack(T initialElement) {
        // Reset visited status
        resetVisitedStatus();

        if (vertexList.isEmpty()) {
            return;
        }

        Vertex vertexWithElement = findVertex(initialElement);

        if (vertexWithElement == null) {
            return;
        }

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

                // Get all adjacent vertices of the popped vertex.
                // If a adjacent has not been visited, then push it
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