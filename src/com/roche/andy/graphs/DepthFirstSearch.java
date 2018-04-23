package com.roche.andy.graphs;

import java.util.Stack;
import java.util.Vector;

public class DepthFirstSearch {
    // A function used by DFS
    private static void DFSUtil(Graph graph, int vertex, boolean visited[]) {
        System.out.print(vertex + " ");

        // Mark the current node as visited and print it
        visited[vertex] = true;

        System.out.println(graph.getAdjacencyLists()[vertex]);

        // Recur for all the vertices adjacent to this vertex
        for (Integer n : graph.getAdjacencyLists()[vertex]) {
            if (!visited[n]) {
                DFSUtil(graph, n, visited);
            }
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    private static void DFS(Graph graph, int vertex) {
        // Mark all the vertices as not visited(set as false by default in java)
        boolean visited[] = new boolean[graph.getNumberOfVertexes()];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(graph, vertex, visited);
    }

    private static void DFSUsingStack(Graph graph, int vertex) {
        int numberOfVertexes = graph.getNumberOfVertexes();

        // Initially mark all vertices as not visited
        Vector<Boolean> visited = new Vector<>(numberOfVertexes);

        for (int i = 0; i < numberOfVertexes; i++) {
            visited.add(false);
        }

        // Create a stack for DFS
        Stack<Integer> stack = new Stack<>();

        // Push the current source node
        stack.push(vertex);

        while (!stack.empty()) {
            // Pop a vertex from stack and print it
            int nextVertex = stack.peek();
            stack.pop();

            System.out.print(nextVertex + " ");
            visited.set(nextVertex, true);

            // Get all adjacent vertices of the popped vertex vertex. If a adjacent has not been visited, then push
            // it to the stack.
            System.out.println(graph.getAdjacencyLists()[nextVertex]);

            for (Integer v : graph.getAdjacencyLists()[nextVertex]) {
                if (!visited.get(v)) {
                    stack.push(v);
                }
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static void main(String args[]) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        int startingVertex = 0;

        System.out.println("Following is Depth First Traversal (starting from vertex " + startingVertex + ")");
        DFS(graph, startingVertex);

        System.out.println("\nFollowing is Depth First Traversal using stack (starting from vertex " + startingVertex +
                ")");
        DFSUsingStack(graph, startingVertex);
    }
}
