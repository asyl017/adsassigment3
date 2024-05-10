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
    }
}
