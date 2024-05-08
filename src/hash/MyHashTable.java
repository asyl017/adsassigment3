package hash;


import java.util.ArrayList;
import java.util.Objects;

public class MyHashTable<K, V> {

    K key;
    V value;

    final int hashCode;


    MyHashTable<K, V> next;


    public MyHashTable(K key, V value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }


    private class HashNode<K, V> {


        private ArrayList<MyHashTable<K, V>> chainArray;

        private int defaultCapacity;

        private int size;


        public HashNode() {
            chainArray = new ArrayList<>();
            defaultCapacity = 10;
            size = 0;

            for (int i = 0; i < defaultCapacity; i++)
                chainArray.add(null);
        }

        public int size() {
            return size;
        }


        private int hashCode(K key) {
            return Objects.hashCode(key);
        }


        private int getIndex(K key) {
            int hashCode = hashCode(key);
            int index = hashCode % defaultCapacity;
            // key.hashCode() could be negative.
            index = index < 0 ? index * -1 : index;
            return index;
        }


        public V remove(K key) {
            int bucketIndex = getIndex(key);
            int hashCode = hashCode(key);
            // Get head of chain
            MyHashTable<K, V> head = chainArray.get(bucketIndex);
            MyHashTable<K, V> prev = null;
            while (head != null) {
                // If Key found
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
                chainArray.set(bucketIndex, head.next);

            return head.value;
        }


        public V getValueByKey(K key) {
            int index = getIndex(key);
            int hashCode = hashCode(key);

            MyHashTable<K, V> head = chainArray.get(index);

            while (head != null) {
                if (head.key.equals(key) && head.hashCode == hashCode)
                    return head.value;
                head = head.next;
            }
            return null;
        }

        public void put(K key, V value) {
            int index = getIndex(key);
            int hashCode = hashCode(key);
            MyHashTable<K, V> head = chainArray.get(index);

            while (head != null) {
                if (head.key.equals(key) && head.hashCode == hashCode) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }

            size++;
            head = chainArray.get(index);
            MyHashTable<K, V> newNode
                    = new MyHashTable<K, V>(key, value, hashCode);
            newNode.next = head;
            chainArray.set(index, newNode);

            if ((1.0 * size) / defaultCapacity >= 0.7) {
                ArrayList<MyHashTable<K, V>> temp = chainArray;
                chainArray = new ArrayList<>();
                defaultCapacity = 2 * defaultCapacity;
                size = 0;
                for (int i = 0; i < defaultCapacity; i++)
                    chainArray.add(null);

                for (MyHashTable<K, V> headNode : temp) {
                    while (headNode != null) {
                        put(headNode.key, headNode.value);
                        headNode = headNode.next;
                    }
                }
            }

        }
    }
    }