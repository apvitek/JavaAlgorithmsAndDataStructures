package com.roche.andy.datastructures;

import java.util.EmptyStackException;

// Java program to implement basic stack operations
class Stack<T> {
    // A linked list (LL) node to store a queue entry
    class SNode<K> {
        K key;
        SNode<K> next;

        // Constructor to create a new linked list node
        SNode(K key) {
            this.key = key;
            this.next = null;
        }
    }

    private SNode<T> top;

    Stack() {
        this.top = null;
    }

    // Method to add an key to the stack
    void push(T key) {
        // Create a new stack node
        SNode<T> temp = new SNode<>(key);

        // If stack is empty, then new node is top and rear both
        if (this.top == null) {
            this.top = temp;
            return;
        }

        // Add the new node at the end of stack and change rear
        temp.next = this.top;
        this.top = temp;
    }

    // Method to remove an key from queue.
    T pop() throws EmptyStackException {
        // If queue is empty, return NULL.
        if (this.top == null) {
            throw new EmptyStackException();
        }

        // Store previous top and move top one node ahead
        SNode<T> temp = this.top;
        this.top = this.top.next;

        return temp.key;
    }
}

class StackTest {
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);

        try {
            System.out.println(s.pop() + " Popped from stack");
            System.out.println(s.pop() + " Popped from stack");
            System.out.println(s.pop() + " Popped from stack");
            System.out.println(s.pop() + " Popped from stack");

        } catch (EmptyStackException e) {
            System.out.println("Stack is empty");
        }
    }
}