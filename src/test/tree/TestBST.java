/**
 * Represents a test class for evaluating the functionality of the Binary Search Tree (BST) implementation.
 */
package test.tree;

import tree.BST;

public class TestBST {
    // Binary Search Tree instance to be tested
    BST<MyBSTKey, MyValue> bst = new BST();

    /**
     * Adds a random set of key-value pairs to the BST for testing purposes.
     * This method populates the BST with 10000 entries using random keys and values.
     */
    public void addRandom() {
        for (int i = 0; i < 10000; i++) {
            MyBSTKey myKey = new MyBSTKey(i ^ 0xaaaaaaaa);
            MyValue myValue = new MyValue(i);
            bst.put(myKey, myValue);
        }
    }
}
