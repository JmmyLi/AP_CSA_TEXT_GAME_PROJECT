import java.util.HashMap;

public class Inventory{
    public static HashMap<String,Integer> inventory = new HashMap<String,Integer>();
    public static void addItem(String item){
        
        inventory.put("item",1);
    }
    public static void delItem(String item){
        inventory.remove("item");
    }
}
