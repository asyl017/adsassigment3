/**
 * Represents a test class for evaluating the functionality of the MyHashTable class.
 */
package test.hash;

import hash.MyHashTable;

public class TestMyHashTable {
    /**
     * Executes a test scenario for the MyHashTable class.
     * This method populates a hash table with instances of MyKeyClass as keys
     * and MyStudent as values, and then performs operations on the hash table.
     */
    public static void test() {
        // Create a new instance of MyHashTable with MyKeyClass as keys and MyStudent as values
        MyHashTable<MyKeyClass, MyStudent> hashtable = new MyHashTable<>();

        // Populate the hash table with 100000 entries
        for (int i = 0; i < 100000; i++) {
            MyKeyClass myKey = new MyKeyClass(i ^ 0xaaaaaaaa);
            MyStudent myValue = new MyStudent(i);
            hashtable.put(myKey, myValue);
        }
    }
}