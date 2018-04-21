package com.roche.andy.graphs;

import java.util.LinkedList;

@SuppressWarnings("ConstantConditions")
class BreadthFirstSearch {
    // The function to do BreadthFirstSearch traversal
    private static void BFS(Graph graph, int vertex) {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[graph.getNumberOfVertexes()];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[vertex] = true;
        queue.add(vertex);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            vertex = queue.poll();
            System.out.print(vertex + " ");

            // Get all adjacent vertices of the dequeued vertex vertex
            // If a adjacent has not been visited, then mark it visited and enqueue it
            for (Integer n : graph.getAdjacencyLists()[vertex]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    // Driver method to
    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int startingVertex = 2;

        System.out.println("Following is Breadth First Traversal (starting from vertex " + startingVertex + ")");

        BFS(g, startingVertex);
    }
}
