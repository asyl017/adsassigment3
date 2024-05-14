package test.tree;

public  class MyBSTKey implements Comparable<MyBSTKey> {
    private int primaryKey;


    public MyBSTKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public int hashCode() {
        int temp = primaryKey;
        temp >>>= 1;
        return temp ^ 0xaaaaaaaa;
    }

    @Override
    public int compareTo(MyBSTKey o) {
        return 0;
    }
}
