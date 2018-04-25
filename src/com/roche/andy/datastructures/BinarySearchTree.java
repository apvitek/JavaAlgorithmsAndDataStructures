package com.roche.andy.datastructures;

// Java program to demonstrate delete operation in binary search tree
@SuppressWarnings({"WeakerAccess"})
public class BinarySearchTree<T extends Comparable<T>> {
    // Class containing left and right child of current node and key value
    private class Node<K> {
        K key;
        Node<K> left, right;

        Node(K item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    private Node<T> root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    // ----- insert -----

    // This method mainly calls insertRecursive()
    public void insert(T key) {
        root = insertRecursive(root, key);
    }

    // A recursive function to insert a new key in BST
    private Node<T> insertRecursive(Node<T> root, T key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node<>(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key.compareTo(root.key) < 0) {
            root.left = insertRecursive(root.left, key);

        } else if (key.compareTo(root.key) > 0) {
            root.right = insertRecursive(root.right, key);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // ----- delete -----

    // This method mainly calls deleteRecursive()
    public void deleteKey(T key) {
        root = deleteRecursive(root, key);
    }

    // A recursive function to delete a key in BST
    private Node<T> deleteRecursive(Node<T> root, T key) {
        // Base Case: If the tree is empty
        if (root == null) {
            return null;
        }

        // Otherwise, recur down the tree
        if (key.compareTo(root.key) < 0) {
            root.left = deleteRecursive(root.left, key);

        } else if (key.compareTo(root.key) > 0) {
            root.right = deleteRecursive(root.right, key);

            // If key is same as root's key, then this is the node to be deleted
        } else {
            // *** Case 1: node with only one child or no child ***
            if (root.left == null) {
                return root.right;

            } else if (root.right == null) {
                return root.left;

            } else {
                // *** Case 2: node with two children ***
                // Get the inorder successor (smallest in the right subtree)
                root.key = minValue(root.right);

                // Delete the inorder successor
                root.right = deleteRecursive(root.right, root.key);
            }
        }

        return root;
    }

    // ----- min -----

    public T minValue(Node<T> root) {
        T minimum = root.key;

        while (root.left != null) {
            minimum = root.left.key;
            root = root.left;
        }

        return minimum;
    }

    // ----- inorder -----

    // This method mainly calls inorderRec()
    public void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    private void inorderRec(Node<T> root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // ----- preorder -----

    // This method mainly calls preorderRec()
    public void preorder() {
        preorderRec(root);
    }

    // A utility function to do preorder traversal of BST
    private void preorderRec(Node<T> root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // ----- postorder -----

    // This method mainly calls postorderRec()
    public void postorder() {
        postorderRec(root);
    }

    // A utility function to do postorder traversal of BST
    private void postorderRec(Node<T> root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
}

class BSTTest {
    public static void main(String args[]) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the original tree: ");
        tree.inorder();
        System.out.println();

        System.out.println("Preorder traversal of the original tree: ");
        tree.preorder();
        System.out.println();

        System.out.println("Postorder traversal of the modified tree: ");
        tree.postorder();
        System.out.println();

        System.out.println();

        System.out.println("Delete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree: ");
        tree.inorder();
        System.out.println();

        System.out.println();

        System.out.println("Delete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree: ");
        tree.inorder();
        System.out.println();

        System.out.println();

        System.out.println("Delete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree: ");
        tree.inorder();
        System.out.println();

        System.out.println("Preorder traversal of the modified tree: ");
        tree.preorder();
        System.out.println();

        System.out.println("Postorder traversal of the modified tree: ");
        tree.postorder();
    }
}