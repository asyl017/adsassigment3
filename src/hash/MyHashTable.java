package hash;


import java.util.ArrayList;
import java.util.Objects;

public class MyHashTable<K, V> {
    private ArrayList<HashNode<K, V>> chainArray;
    private int defaultCapacity;
    private int size;


    public MyHashTable() {
        chainArray = new ArrayList<>();
        defaultCapacity = 10;
        size = 0;

        for (int i = 0; i < defaultCapacity; i++) {
            chainArray.add(null);
        }
    }

    private static class HashNode<K, V> {
        K key;
        V value;
        final int hashCode;
        HashNode<K, V> next;

        public HashNode(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }

        @Override
        public String toString() {
            return "{" + key + "=>" + value + "}";
        }
    }

    public int size() {
        return size;
    }


    private int hash(K key) {
        return Objects.hashCode(key);
    }


    private int getIndex(K key) {
        int hashCode = hash(key);
        return Math.abs(hashCode) % defaultCapacity;
    }

    public K getKey(V value) {
        for (HashNode<K, V> node : chainArray)
            while (node != null) {
                if (node.value.equals(value)) return node.key;
                node = node.next;
            }
        return null;
    }


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

    private void reIndexation(ArrayList<HashNode<K, V>> temp) {
        for (HashNode<K, V> headNode : temp) {
            while (headNode != null) {
                put(headNode.key, headNode.value);
                headNode = headNode.next;
            }
        }
    }

    public boolean contains(V value) {
        if (getKey(value) != null) {
            return true;
        } else return false;
    }

}

