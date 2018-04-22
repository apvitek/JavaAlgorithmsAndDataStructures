package com.roche.andy.datastructures;

class DoublyLinkedList<T extends Comparable<T>> {
    // Doubly Linked list Node
    class Node<K> {
        K data;
        Node<K> prev, next;

        // Constructor to create a new node; next and prev is by default initialized as null
        Node(K d) {
            data = d;
        }
    }

    Node<T> head; // head of list

    // Adding a node at the front of the list
    void push(T newData) {
        // 1. Allocate node
        // 2. Put in the data
        Node<T> newNode = new Node<>(newData);

        // 3. Make next of new node as head and previous as NULL
        newNode.next = head;
        newNode.prev = null;

        // 4. Change prev of head node to new node
        if (head != null)
            head.prev = newNode;

        // 5. Move the head to point to the new node
        head = newNode;
    }

    // Given a node as previousNode, insert a new node after the given node
    void insertAfter(Node previousNode, T newData) {
        // 1. Check if the given prev_node is NULL
        if (previousNode == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        // 2. Allocate node
        // 3. Put in the data
        Node newNode = new Node<>(newData);

        // 4. Make next of new node as next of prev_node
        newNode.next = previousNode.next;

        // 5. Make the next of prev_node as newNode
        previousNode.next = newNode;

        // 6. Make prev_node as previous of newNode
        newNode.prev = previousNode;

        // 7. Change previous of newNode's next node
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    // Given a node as previousNode, insert a new node before the given node
    void insertBefore(Node previousNode, T newData) {
        if (previousNode == head) {
            push(newData);

        } else {
            insertAfter(previousNode.prev, newData);
        }
    }

    // Add a node at the end of the list
    void append(T newData) {
        // 1. allocate node
        // 2. put in the data
        Node<T> newNode = new Node<>(newData);
        Node<T> last = head;

        // 3. This new node is going to be the last node, so make next of it as NULL
        newNode.next = null;

        // 4. If the Linked List is empty, then make the new node as head
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        // 5. Else traverse till the last node
        while (last.next != null) {
            last = last.next;
        }

        // 6. Change the next of last node
        last.next = newNode;

        // 7. Make last node as previous of new node
        newNode.prev = last;
    }

    // This function prints contents of linked list starting from the given node
    void printList() {
        Node<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}

class DLLTest {
    public static void main(String[] args) {
        // Start with the empty list
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        // Insert 6. So linked list becomes 6->NULL
        dll.append(6);

        // Insert 7 at the beginning. So linked list becomes 7->6->NULL
        dll.push(7);

        // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
        dll.push(1);

        // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL
        dll.append(4);
        dll.printList();

        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL
        dll.insertAfter(dll.head.next, 8);
        dll.printList();

        // Insert 9, before head. So linked list becomes 9->1->7->8->6->4->NULL
        dll.insertBefore(dll.head, 9);
        dll.printList();
    }
}