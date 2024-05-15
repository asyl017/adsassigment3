/**
 * Represents a test class for evaluating the functionality of the Binary Search Tree (BST) implementation.
 */
package test.tree;

import hash.MyHashTable;
import test.hash.MyTestingClass;
import test.hash.MyStudent;
import tree.BST;

public class TestBST {
    /**
     * Executes a test scenario for the MyHashTable class.
     * This method populates a hash table with instances of MyKeyClass as keys
     * and MyStudent as values, and then performs operations on the hash table.
     */
    public static void addRandom() {
        // Create a new instance of MyHashTable with MyKeyClass as keys and MyStudent as values
        BST<MyTestingClass, MyStudent> hashtable = new BST<>();
        // Populate the hash table with 100000 entries
        for (int i = 0; i < 100000; i++) {
            MyTestingClass myKey = new MyTestingClass(i ^ 0xaaaaaaaa);
            MyStudent myValue = new MyStudent(i);
            hashtable.put(myKey, myValue);
        }
    }

}

