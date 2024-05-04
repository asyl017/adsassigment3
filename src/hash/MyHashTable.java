package hash;

public class MyHashTable<K, V> {
    private class Hashnode<K, V> {
        private K key;
        private V value;

        public Hashnode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{ " + key + " " + value + "}";
        }
    }

    private Hashnode<K, V>[] chainArray;
    private int defaultCapacity = 15; // default number of chains
    private int size;

    public MyHashTable() {

    }

    public MyHashTable(int initialCapacity) {

    }

    public int hash(K key) {
        return 0;
    }

    public void put(K key, V value) {

    }

    public V get(K key) {
        return null;
    }

    public V remove(K key) {
        return null;
    }

    public boolean contains(V value) {
        return false;
    }

    public K getKey(V value) {
        return null;
    }

}
