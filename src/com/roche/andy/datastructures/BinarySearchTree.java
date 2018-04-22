package com.roche.andy.datastructures;

// Java program to demonstrate delete operation in binary search tree
@SuppressWarnings({"WeakerAccess", "ConstantConditions", "unchecked"})
class BinarySearchTree<T extends Comparable<T>> {
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
    BinarySearchTree() {
        root = null;
    }

    // This method mainly calls insertRecursive()
    void insert(T key) {
        root = insertRecursive(root, key);
    }

    // A recursive function to insert a new key in BST
    private Node insertRecursive(Node<T> root, T key) {
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

    // This method mainly calls deleteRecursive()
    void deleteKey(T key) {
        root = deleteRecursive(root, key);
    }

    // A recursive function to delete a key in BST
    private Node deleteRecursive(Node<T> root, T key) {
        // Base Case: If the tree is empty
        if (root == null) {
            return root;
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
            }

            // *** Case 2: node with two children ***
            // Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRecursive(root.right, root.key);
        }

        return root;
    }

    T minValue(Node<T> root) {
        T minimum = root.key;

        while (root.left != null) {
            minimum = root.left.key;
            root = root.left;
        }

        return minimum;
    }

    // This method mainly calls inorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // This method mainly calls preorderRec()
    void preorder() {
        preorderRec(root);
    }

    // A utility function to do preorder traversal of BST
    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // This method mainly calls postorderRec()
    void postorder() {
        postorderRec(root);
    }

    // A utility function to do postorder traversal of BST
    private void postorderRec(Node root) {
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

        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nPreorder traversal of the modified tree");
        tree.preorder();

        System.out.println("\nPostorder traversal of the modified tree");
        tree.postorder();

        System.out.println();

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);

        System.out.println();

        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nPreorder traversal of the modified tree");
        tree.preorder();

        System.out.println("\nPostorder traversal of the modified tree");
        tree.postorder();
    }
}