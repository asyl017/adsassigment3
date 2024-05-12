package hash;


import java.util.ArrayList;
import java.util.Objects;

/**
 * A custom implementation of a hash table data structure.
 * This implementation uses separate chaining to handle collisions.
 *
 * @param <K> the type of keys stored in the hash table
 * @param <V> the type of values stored in the hash table
 */
public class MyHashTable<K, V> {
    private ArrayList<HashNode<K, V>> chainArray;
    private int defaultCapacity;
    private int size;

    /**
     * Constructs a new MyHashTable with a default capacity of 10.
     */

    public MyHashTable() {
        chainArray = new ArrayList<>();
        defaultCapacity = 10;
        size = 0;

        for (int i = 0; i < defaultCapacity; i++) {
            chainArray.add(null);
        }
    }

    /**
     * Returns a string representation of the node.
     *
     * @return a string representation of the node
     */

    private static class HashNode<K, V> {
        K key;
        V value;
        final int hashCode;
        HashNode<K, V> next;

        /**
         * Constructs a new HashNode with the specified key, value, and hash code.
         *
         * @param key      the key to be stored in the node
         * @param value    the value to be stored in the node
         * @param hashCode the hash code of the key
         */
        public HashNode(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }

        /**
         * Returns a string representation of the node.
         *
         * @return a string representation of the node
         */

        @Override
        public String toString() {
            return "{" + key + "=>" + value + "}";
        }
    }

    /**
     * This method retrieves the number of key-value mappings in this hash table.
     *
     * @return the number of key-value mappings in this hash table
     */
    public int size() {
        return size;
    }


    private int hash(K key) {
        return Objects.hashCode(key);
    }

    /**
     * This method computes the index in the chainArray for the specified key.
     *
     * @param key the key for which to compute the index
     * @return the index in the chainArray for the specified key
     */

    private int getIndex(K key) {
        int hashCode = hash(key);
        return Math.abs(hashCode) % defaultCapacity;
    }

    /**
     * This method returns the key associated with the specified value in this hash table.
     *
     * @param value the value whose associated key is to be retrieved
     * @return the key associated with the specified value, or null if no mapping exists for the value
     */
    public K getKey(V value) {
        for (HashNode<K, V> node : chainArray)
            while (node != null) {
                if (node.value.equals(value)) return node.key;
                node = node.next;
            }
        return null;
    }

    /**
     * This method removes the mapping for the specified key from this hash table if it presents.
     *
     * @param key the key whose mapping is to be removed from the hash table
     * @return the previous value associated with the specified key, or null if there was no mapping for the key
     */

    public V remove(K key) {
        int index = getIndex(key);
        int hashCode = hash(key);

        HashNode<K, V> head = chainArray.get(index);
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key) && hashCode == head.hashCode)
                break;
            prev = head;
            head = head.next;
        }


        if (head == null)
            return null;
        size--;


        if (prev != null)
            prev.next = head.next;
        else
            chainArray.set(index, head.next);

        return head.value;
    }

    /**
     * This method retrieves the value associated with the specified key in this hash table.
     *
     * @param key the key whose associated value is to be retrieved
     * @return the value associated with the specified key, or null if no mapping exists for the key
     */
    public V getValueByKey(K key) {
        int index = getIndex(key);
        int hashCode = hash(key);

        HashNode<K, V> head = chainArray.get(index);

        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode)
                return head.value;
            head = head.next;
        }
        return null;
    }

    /**
     * This method associates the specified value with the specified key in this hash table.
     * If the hash table previously contained a mapping for the key, the old value is replaced by the specified value.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     */
    public void put(K key, V value) {
        int index = getIndex(key);
        int hashCode = hash(key);
        HashNode<K, V> head = chainArray.get(index);

        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = chainArray.get(index);
        HashNode<K, V> newNode = new HashNode<>(key, value, hashCode);
        newNode.next = head;
        chainArray.set(index, newNode);

        increaseBuffer();
    }

    /**
     * This method increases the capacity of the hash table when the load factor exceeds 0.7.
     */
    private void increaseBuffer() {
        if (!((1.0 * size) / defaultCapacity >= 0.7)) {
            return;
        }
        ArrayList<HashNode<K, V>> temp = new ArrayList<>();
        chainArray = new ArrayList<>();
        defaultCapacity = 2 * defaultCapacity;
        size = 0;
        for (int i = 0; i < defaultCapacity; i++) {
            chainArray.add(null);
        }

        reIndexation(temp);
    }

    /**
     * Re-indexes the hash table after increasing the buffer size.
     *
     * @param temp the temporary array used during re-indexing
     */
    private void reIndexation(ArrayList<HashNode<K, V>> temp) {
        for (HashNode<K, V> headNode : temp) {
            while (headNode != null) {
                put(headNode.key, headNode.value);
                headNode = headNode.next;
            }
        }
    }

    /**
     * This method checks whether this hash table contains a mapping for the specified value.
     *
     * @param value the value to be checked for containment in this hash table
     * @return true if this hash table contains a mapping for the specified value, otherwise false
     */

    public boolean contains(V value) {
        return getKey(value) != null;
    }

}

