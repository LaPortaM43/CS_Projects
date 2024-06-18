package edu.monmouth.tree;

class Tree {
    private Node root; // first node of tree

    // Constructor
    public Tree() {
        root = null;
    }

    // Method to insert a new node with given key and value
    public void insert(int key, double value) {
        root = insertRec(root, key, value);
    }

    // Recursive helper method to insert a new node
    private Node insertRec(Node root, int key, double value) {
        // If the tree is empty, create a new node as the root
        if (root == null) {
            root = new Node(key, value);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.getkey())
            root.leftChild = insertRec(root.leftChild, key, value);
        else if (key > root.getkey())
            root.rightChild = insertRec(root.rightChild, key, value);

        // Return the (unchanged) node pointer
        return root;
    }

    // Method to find a node with a given key
    public Node find(int key) {
        Node current = root;
        
        // Traverse the tree until a node with the given key is found or until the end of the tree is reached
        while (current != null) {
            if (key == current.getkey()) {
                return current; // Found the node with the given key
            } else if (key < current.getkey()) {
                current = current.leftChild; // Search in the left subtree
            } else {
                current = current.rightChild; // Search in the right subtree
            }
        }
        
        return null; // Key not found in the tree
    }

    // Method to find the node with the minimum key
    public Node min() {
        return minRec(root);
    }

    // Recursive helper method to find the node with the minimum key
    private Node minRec(Node root) {
        // Keep traversing left until we reach the leftmost node (smallest key)
        while (root != null && root.leftChild != null)
            root = root.leftChild;
        return root;
    }

    // Method to find the node with the maximum key
    public Node max() {
        return maxRec(root);
    }

    // Recursive helper method to find the node with the maximum key
    private Node maxRec(Node root) {
        // Keep traversing right until we reach the rightmost node (largest key)
        while (root != null && root.rightChild != null)
            root = root.rightChild;
        return root;
    }

    // Method to perform inorder traversal
    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal:  ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    // Recursive method to perform preorder traversal
    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.getkey() + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    // Recursive method to perform inorder traversal
    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.getkey() + " ");
            inOrder(localRoot.rightChild);
        }
    }

    // Recursive method to perform postorder traversal
    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.getkey() + " ");
        }
    }
}
