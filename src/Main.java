/**
 * Main class for testing various data structures.
 * This class contains a main method where instances of Hashtable, BST, and custom implementations are tested.
 */

import hash.MyHashTable;
import test.hash.TestK;
import test.tree.TestBST;
import tree.BST;

import java.util.Hashtable;

/**
 * The entry point of the program.
 *
 * @param args command line arguments (not used in this program)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Test of Hashtable");
        // Testing Hashtable with String keys and Integer values
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("Kevin Levrone", 21);
        hashtable.put("Naser El Sonbaty", 1);
        hashtable.put("Dorian Yates", 22);
        hashtable.put("Shawn Ray", 15);
        hashtable.put("Branch Worren", 31);


        hashtable.remove("Branch Worren");
        System.out.println(hashtable);
        System.out.println(hashtable.contains(31));


        System.out.println("Test of Binary Search Tree");
        // Testing Binary Search Tree (BST) with Integer keys and Integer values
        BST<Integer, Integer> bst = new BST<>();
        bst.put(12, 21);
        bst.put(31, 2);
        bst.put(3, 22);
        bst.put(1, 15);
        bst.put(100, 121);
        bst.put(99, 31);
        System.out.println(bst.findSmallestValue());
        bst.remove(12);
        System.out.print("bst after remove: ");
        bst.inorderTraversal();
        System.out.println("Element with key 99 " + bst.get(99));



        // Testing custom hashtable implementation
        TestK ht = new TestK();
        ht.addRandom();

        // Testing custom BST implementation
        TestBST bsTree = new TestBST();
        bsTree.addRandom();
    }
}
