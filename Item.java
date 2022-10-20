public class Item {
    String name;
    int num;
    public String description;
    String[] itemList = new String[]{
        "A red key",
        "A blue key",
        "A yellow key",
        "Strange letter 1",
        "Strange letter 2",
        "Strange letter 3",
        "A list",
        "A shining coin",
        "An odd stone"};

    public Item(String itemName){
        this.name = itemName;
        this.num = 1;
        this.description="";
    }
    
    public Item(String itemName,int n){
        this.name = itemName;
        this.num = n;
        this.description="";
    }
}
