package com.roche.andy.graphs;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class DFSandBFSGraph {
    static void DFS(GenericGraph.Vertex vertex) {
        // 1. Perform operation
        System.out.print(vertex.getValue() + " ");

        // 2. Mark the current note ad visited
        vertex.setVisited();

        // 3. Recur for all the vertices adjacent to this vertex
        for (Object v : vertex.getAdjacentList()) {
            GenericGraph.Vertex thisVertex = (GenericGraph.Vertex) v;

            // 4. If the vertex is not visited, recurse on that vertex
            if (thisVertex.isNotVisited()) {
                DFS(thisVertex);
            }
        }
    }

    static void BFS(GenericGraph.Vertex vertex) {
        // 1. Create a queue for BFS
        Queue<GenericGraph.Vertex> queue = new LinkedList<>();

        // 2. Mark the current vertex as visited
        vertex.setVisited();

        // 3. Enqueue current vertex
        queue.add(vertex);

        // 4. While the queue is not empty
        while (!queue.isEmpty()) {
            // 5. Dequeue a vertex from queue
            GenericGraph.Vertex nextVertex = queue.poll();

            // 6. Perform operation
            System.out.print(Objects.requireNonNull(nextVertex).getValue() + " ");

            // 7. Iterate through all adjacent vertices of the dequeued vertex
            for (Object v : nextVertex.getAdjacentList()) {
                GenericGraph.Vertex thisVertex = (GenericGraph.Vertex) v;

                // 8. If a adjacent has not been visited, then mark it visited and enqueue it
                if (thisVertex.isNotVisited()) {
                    thisVertex.setVisited();
                    queue.add(thisVertex);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    static void DFSIterative(GenericGraph graph, GenericGraph.Vertex vertex) {
        // 1. Create a stack for DFS
        Stack<GenericGraph.Vertex> stack = new Stack<>();

        // 2. Mark the current vertex as visited
        vertex.setVisited();

        // 3. Enqueue current vertex
        stack.push(vertex);

        // 4. While the stack is not empty
        while (!stack.isEmpty()) {
            // 5. Pop a vertex from stack
            GenericGraph.Vertex nextVertex = stack.pop();

            // 6. Perform operation
            System.out.print(Objects.requireNonNull(nextVertex).getValue() + " ");

            // 7. Iterate through all adjacent vertices of the dequeued vertex
            for (Object v : new Reversed(nextVertex.getAdjacentList())) {
                GenericGraph.Vertex thisVertex = (GenericGraph.Vertex) v;

                // 8. If the vertex is not visited, mark it visited and push it on the stack
                if (thisVertex.isNotVisited()) {
                    thisVertex.setVisited();
                    stack.push(thisVertex);
                }
            }
        }
    }

    public static void main(String args[]) {
        GenericGraph<Integer> graph = new GenericGraph<>();

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);

        GenericGraph.Vertex startingVertex = graph.findVertex(0);

        System.out.println("Breadth First Traversal (starting from vertex " + startingVertex.getValue() + ")");

        BFS(startingVertex);

        graph.resetVisitedStatus();

        System.out.println("\n\nDepth First Traversal (starting from vertex " + startingVertex.getValue() + ")");

        DFS(startingVertex);

        graph.resetVisitedStatus();

        System.out.println("\n\nDepth First Traversal iterative (starting from vertex " + startingVertex.getValue() + ")");

        DFSIterative(graph, startingVertex);
    }
}
