package com.roche.andy;

public class DepthFirstSearch {
    // A function used by DepthFirstSearch
    private static void DFSUtil(Graph graph, int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        for (Integer n : graph.getAdjacencyLists()[v]) {
            if (!visited[n]) {
                DFSUtil(graph, n, visited);
            }
        }
    }

    // The function to do DepthFirstSearch traversal. It uses recursive DFSUtil()
    private static void DFS(Graph graph, int v) {
        // Mark all the vertices as not visited(set as false by default in java)
        boolean visited[] = new boolean[graph.getNumberOfVertexes()];

        // Call the recursive helper function to print DepthFirstSearch traversal
        DFSUtil(graph, v, visited);
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int startingVertex = 2;

        System.out.println("Following is Depth First Traversal (starting from vertex " + startingVertex + ")");

        DFS(g, startingVertex);
    }
}
