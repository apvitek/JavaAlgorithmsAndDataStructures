package com.roche.andy.datastructures;

import java.util.EmptyStackException;

// Java program to implement basic stack operations
class Stack {
    // A linked list (LL) node to store a queue entry
    class SNode {
        int key;
        SNode next;

        // Constructor to create a new linked list node
        SNode(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private SNode top;

    Stack() {
        this.top = null;
    }

    // Method to add an key to the stack
    void push(int key) {
        // Create a new stack node
        SNode temp = new SNode(key);

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
    SNode pop() throws EmptyStackException {
        // If queue is empty, return NULL.
        if (this.top == null) {
            throw new EmptyStackException();
        }

        // Store previous top and move top one node ahead
        SNode temp = this.top;
        this.top = this.top.next;

        return temp;
    }
}

class StackTest {
    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);

        try {
            System.out.println(s.pop().key + " Popped from stack");
            System.out.println(s.pop().key + " Popped from stack");
            System.out.println(s.pop().key + " Popped from stack");
            System.out.println(s.pop().key + " Popped from stack");

        } catch (EmptyStackException e) {
            System.out.println("Stack is empty");
        }
    }
}