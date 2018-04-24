package com.roche.andy.datastructures;

// A class to represent a queue
class Queue<T> {
    // A linked list (LL) node to store a queue entry
    private class QNode<K> {
        K key;
        QNode<K> next;

        // Constructor to create a new linked list node
        QNode(K key) {
            this.key = key;
            this.next = null;
        }
    }

    private QNode<T> front, rear;

    Queue() {
        this.front = this.rear = null;
    }

    // Method to add an key to the queue.
    void enqueue(T key) {
        // Create a new LL node
        QNode<T> temp = new QNode<>(key);

        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;
    }

    // Method to remove an key from queue.
    T dequeue() {
        // If queue is empty, return NULL.
        if (this.front == null) {
            return null;
        }

        // Store previous front and move front one node ahead
        QNode<T> temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null) {
            this.rear = null;
        }

        return temp.key;
    }
}

class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        System.out.println("Dequeued item is " + q.dequeue());
    }
}