package test.tree;

import tree.BST;

public class TestBST<K, V> {
    BST<MyBSTKey, MyValue> bst = new BST();

    public void addRandom() {
        for (int i = 0; i < 10000; i++) {
            MyBSTKey myKey = new MyBSTKey(i ^ 0xaaaaaaaa);
            MyValue myValue = new MyValue(i);
            bst.put(myKey, myValue);
        }
    }
}
