package com.roche.andy.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlternate {
    static class Node {
        int data;
        boolean visited;
        List<Node> neighbours;

        Node(int data) {
            this.data = data;
            this.neighbours = new ArrayList<>();

        }

        void addNeighbors(Node neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        List<Node> getNeighbours() {
            return neighbours;
        }
    }

    // Recursive DFS
    private void dfs(Node node) {
        System.out.print(node.data + " ");
        List<Node> neighbours = node.getNeighbours();
        node.visited = true;

        for (Node n : neighbours) {
            if (n != null && !n.visited) {
                dfs(n);
            }
        }
    }

    // Iterative DFS using stack
    private void dfsUsingStack(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        node.visited = true;

        while (!stack.isEmpty()) {
            Node element = stack.pop();
            System.out.print(element.data + " ");

            List<Node> neighbours = element.getNeighbours();

            for (Node n : neighbours) {
                if (n != null && !n.visited) {
                    stack.add(n);
                    n.visited = true;
                }
            }
        }
    }

    public static void main(String arg[]) {
        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);

        node40.addNeighbors(node10);
        node40.addNeighbors(node20);
        node10.addNeighbors(node30);
        node20.addNeighbors(node10);
        node20.addNeighbors(node30);
        node20.addNeighbors(node60);
        node20.addNeighbors(node50);
        node30.addNeighbors(node60);
        node60.addNeighbors(node70);
        node50.addNeighbors(node70);

        DepthFirstSearchAlternate dfsExample = new DepthFirstSearchAlternate();

        System.out.println("The DFS traversal of the graph using stack ");
        dfsExample.dfsUsingStack(node40);

        System.out.println();

        // Resetting the visited flag for nodes
        node40.visited = false;
        node10.visited = false;
        node20.visited = false;
        node30.visited = false;
        node60.visited = false;
        node50.visited = false;
        node70.visited = false;


        System.out.println("The DFS traversal of the graph using recursion ");
        dfsExample.dfs(node40);
    }
}