public class Item extends Inventory{
    String name;
    int num;
    public String description;
    public static String[] itemList = new String[]{
        "A red key",
        "A blue key",
        "A yellow key",
        "Strange letter 1",//
        "Strange letter 2",//
        "Strange letter 3",//
        "An envelop",
        "A shining coin",//
        "An odd stone"};
    public static String[] itemDescrption = new String[]{
        "",
        "",
        "",
        "I put all of my money into the fountain to get the happiness from the stone. But now I don't have any choices. My food just ran out, and I can't find any way out from this creepy labyrinth!\nI think I might die soon.",//
        "The two statue are dead, and I cannot find any way to enter the two guarded wall.",//
        "I looked through the wall besides the last door, and I found a huge pyramid-like building inside the room.",//
        "",
        "It is a coin that made of gold, and there is a image on it and seem to be one god, you think it is might for the luck.",//
        "An odd stone have blue mark on it, and it seems to be connected to something, when you touch it, you can feel a strong power on it."};

    // public Item(String itemName){
    //     this.name = itemName;
    //     this.num = 1;
    //     this.description="";
    // }
    
    // public Item(String itemName,int n){
    //     this.name = itemName;
    //     this.num = n;
    //     this.description="";
    // }
}
