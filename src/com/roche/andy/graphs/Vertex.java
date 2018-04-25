package com.roche.andy.graphs;

import java.util.ArrayList;

// Vertex class
public class Vertex<T> {
    private T value;
    private ArrayList<Vertex<T>> adjacencyList;
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

    public ArrayList<Vertex<T>> getAdjacentList() {
        return adjacencyList;
    }

    public void addNeighbor(Vertex<T> n) {
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
