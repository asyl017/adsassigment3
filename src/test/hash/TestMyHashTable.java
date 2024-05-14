package test.hash;


import hash.MyHashTable;

public class TestMyHashTable {
    public static void test() {
        MyHashTable<MyKeyClass, MyStudent> hashtable = new MyHashTable<>();


        for (int i = 0; i < 100000; i++) {
            MyKeyClass myKey = new MyKeyClass(i ^ 0xaaaaaaaa);
            MyStudent myValue = new MyStudent(i);
            hashtable.put(myKey, myValue);
        }
    }
}