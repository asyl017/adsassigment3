package test.hash;

public class MyKeyClass  {
    private int primaryKey;


    public MyKeyClass(int primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public int hashCode() {
        int temp = primaryKey;
        temp >>>= 1;
        return temp ^ 0xaaaaaaaa;
    }
}
