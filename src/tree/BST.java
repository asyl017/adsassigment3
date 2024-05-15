package tree;

/**
 * A generic Binary Search Tree implementation.
 *
 * @param <K> The type of keys in the tree, must implement Comparable interface.
 * @param <V> The type of values associated with the keys.
 */
public class BST<K extends Comparable<K>, V> {
    private Node root;

    /**
     * Internal representation of a node in the binary tree.
     */
    private class Node {
        private K key;
        private V value;
        private Node left, right;

        /**
         * Constructor to initialize a node with a key and a value.
         *
         * @param key   The key of the node.
         * @param value The value associated with the key.
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    /**
     * Get the value associated with a given key in the tree.
     *
     * @param key The key to search for.
     * @return The value associated with the key, or null if key is not found.
     */
    public V get(K key) {
        return get(root, key);
    }

    // Helper method for recursive search
    private V get(Node node, K key) {
        if (node == null)
            return null;
        int compareKeys = key.compareTo(node.key);
        if (compareKeys == 0)
            return node.value;
        if (compareKeys < 0)
            return get(node.left, key);
        else
            return get(node.right, key);
    }

    /**
     * Insert a key-value pair into the tree.
     *
     * @param key   The key to be inserted.
     * @param value The value associated with the key.
     */
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    // Helper method for recursive insertion
    private Node put(Node current, K key, V value) {
        if (current == null)
            return new Node(key, value);
        int compareKeys = key.compareTo(current.key);
        if (compareKeys < 0)
            current.left = put(current.left, key, value);
        else
            current.right = put(current.right, key, value);
        return current;
    }

    /**
     * Remove a key-value pair from the tree.
     *
     * @param key The key to be removed.
     * @return The removed node, or null if key doesn't exist in the tree.
     */
    public Node remove(K key) {
        remove(root, key);
        return null;
    }

    // Helper method for recursive removal
    private Node remove(Node current, K key) {
        if (current == null)
            return null;
        int compareKeys = key.compareTo(current.key);
        if (compareKeys < 0)
            current.left = remove(current.left, key);
        else if (compareKeys > 0)
            current.right = remove(current.right, key);
        else {
            if (current.left == null && current.right == null)
                return null;


            if (current.left == null)
                return current.right;

            if (current.right == null)
                return current.left;

            current.key = findSmallestValue(current.right).key;
            current.value = findSmallestValue(current.right).value;
            current.right = remove(current.right, current.key);
        }
        return current;
    }

    /**
     * Get an iterator for the tree.
     *
     * @return An iterator for traversing the tree.
     */
    public Iterable<K> iterator() {
        return iterator();
    }

    /**
     * Find the key of the smallest node in the tree.
     *
     * @return The key of the smallest node, or null if tree is empty.
     */
    public K findSmallestValue() {
        if (root == null) {
            return null;
        }
        return findSmallestValue(root).key;
    }

    /**
     * Perform an inorder traversal of the tree and print the nodes.
     */
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    // Helper method for recursive inorder traversal
    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println("Key: " + node.key + ", Value: " + node.value);
            inorderTraversal(node.right);
        }
    }

    // Helper method to find the node with the smallest key in a subtree
    private Node findSmallestValue(Node node) {
        return node.left == null ? node : findSmallestValue(node.left);
    }

}
