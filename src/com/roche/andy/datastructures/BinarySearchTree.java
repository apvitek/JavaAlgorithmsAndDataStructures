package com.roche.andy.datastructures;

// Java program to demonstrate delete operation in binary search tree
@SuppressWarnings({"WeakerAccess", "ConstantConditions"})
class BinarySearchTree {
    // Class containing left and right child of current node and key value
    class Node {
        int key;
        Node left, right;

        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    private Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // This method mainly calls deleteRecursive()
    void deleteKey(int key) {
        root = deleteRecursive(root, key);
    }

    // A recursive function to insert a new key in BST
    Node deleteRecursive(Node root, int key) {
        // Base Case: If the tree is empty
        if (root == null) {
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key) {
            root.left = deleteRecursive(root.left, key);

        } else if (key > root.key) {
            root.right = deleteRecursive(root.right, key);

            // if key is same as root's key, then This is the node to be deleted
        } else {
            // node with only one child or no child
            if (root.left == null) {
                return root.right;

            } else if (root.right == null) {
                return root.left;
            }

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRecursive(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minimum = root.key;

        while (root.left != null) {
            minimum = root.left.key;
            root = root.left;
        }

        return minimum;
    }

    // This method mainly calls insertRecursive()
    void insert(int key) {
        root = insertRecursive(root, key);
    }

    // A recursive function to insert a new key in BST
    Node insertRecursive(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key) {
            root.left = insertRecursive(root.left, key);

        } else if (key > root.key) {
            root.right = insertRecursive(root.right, key);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // This method mainly calls InorderRec()
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
}

class BSTTest {
    public static void main(String args[]) {
        BinarySearchTree tree = new BinarySearchTree();

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

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

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
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
    }
}