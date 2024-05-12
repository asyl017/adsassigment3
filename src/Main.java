import tree.BST;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
       Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("Kevin Levrone", 21);
        hashtable.put("Naser El Sonbaty", 1);
        hashtable.put("Dorian Yates", 22);
        hashtable.put("Shawn Ray", 15);
        hashtable.put("Branch Worren", 31);


        System.out.println(hashtable);
        System.out.println(hashtable.contains(31));


        BST<Integer, Integer> bst = new BST<>();
        bst.put(12, 21);
        bst.put(31, 2);
        bst.put(3, 22);
        bst.put(1, 15);
        bst.put(99, 31);
        System.out.println(bst.findSmallestValue());
        bst.remove(12);
        System.out.print("bst after remove: ");
        bst.inorderTraversal();
        System.out.println("Element with key 99" + bst.get(99));
    }
}
