package tree;

public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    public V get(K key) {
        return get(root, key);
    }

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

    public void put(K key, V value) {
        root = put(root, key, value);
    }

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


    public Node remove(K key) {
        remove(root, key);
        return null;
    }

    private Node remove(Node current, K key) {
        if (current == null)
            return null;
        int compareKeys = key.compareTo(current.key);
        if (compareKeys < 0)
            current.left = remove(current.left, key);
        else if (compareKeys > 0)
            current.right = remove(current.right, key);
        else {
            //case 1: no child
            if (current.left == null && current.right == null)
                return null;

            //case 2: only one child

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

    public Iterable<K> iterator() {
        return iterator();
    }

    public K findSmallestValue() {
        if (root == null) {
            return null;
        }
        return findSmallestValue(root).key;
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println("Key: " + node.key + ", Value: " + node.value);
            inorderTraversal(node.right);
        }
    }

    private Node findSmallestValue(Node node) {
        return node.left == null ? node : findSmallestValue(node.left);
    }
}
