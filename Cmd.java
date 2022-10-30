import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Cmd {
    static boolean 
    beginning=true,
    canOpen=false,
    canGet=false,
    isOnUd=false;
    public static void run(String cmd){
        int csize=cmd.length();
        String one=new String();
        if(csize>0) {one+=cmd.charAt(0);}
        
        if(eq(cmd, "help")) {help();}
        if(eq(Main.page,"game"))
        {
            if(eq(cmd, "i")||eq(cmd, "inventory")) {inventory();Main.page=cmd;}
            else if(eq(cmd, "l")||eq(cmd,"look")) look();
            else if(eq(cmd, "m")||eq(cmd, "map")) {openMap();Main.page=cmd;}
            else if(eq(one, "w")) {
                if(csize==1)w();else w(cmd.charAt(1)-'0');
                // setMap();
                instruct();}
            else if(eq(one, "s")) {
                if(csize==1)s();else s(cmd.charAt(1)-'0');
                // setMap();
                instruct();}
            else if(eq(one, "a")) {
                if(csize==1)a();else a(cmd.charAt(1)-'0');
                // setMap();
                instruct();}
            else if(eq(one, "d")) {
                if(csize==1)d();else d(cmd.charAt(1)-'0');
                // setMap();
                instruct();}
            if(cmd.length()>5&&eq(cmd.substring(0, 3), "get")){
                if(canGet){
                    int itemIndex=-1;
                    
                    if(cmd.indexOf("coin")>0&&eq(Map.pos,"A shining coin")){
                        Inventory.addItem(Map.pos);
                        remove(5,12);
                        canGet=false;
                        Map.pos="origin";
                        // setMap();
                        instruct();
                        System.out.println("You got the item!");
                    }
                    else if(Map.letters&&cmd.indexOf("letter")>0&&eq(Map.pos, "letters")){
                        for(int i=3;i<6;++i) Inventory.addItem(Item.itemList[i]);
                        remove(9,17);remove(8,18);remove(10,18);
                        Map.letters=false;canGet=false;
                        Map.pos="origin";
                        // setMap();
                        instruct();
                        System.out.println("You got the item!");
                    }
                    else System.out.println("Sorry, there's no such item.");
                    
                    // for(String a:Item.itemList){
                        //     if(cmd.indexOf(a)>=0){itemIndex=cmd.indexOf(a);}
                            // }
                }else{System.out.println("Sorry, there's no any other item here.");}
            }
        }

        if(eq(cmd, "clear")||eq(cmd, "cls")) cls();
        if(eq(cmd, "b")||eq(cmd,"back")) {
            Main.page="game";cls();
            // setMap();
            instruct();
        }
        else if(!eq(Main.page,"game")) System.out.println("Type 'BACK' or 'b' back to the main game");

        if(canOpen&&eq(cmd, "try")){
            Main.page="solving";openDoor();
        }
    }

    private static void help(){
        cls();
        System.out.println("Basics:");
        System.out.println("Type W,A,S,D to navigate");
        System.out.println("Type 'INVENTORY' or 'I' to open your bag");
        System.out.println("Type 'MAP' or 'M' to open your map");
        System.out.println("    -The map will only show things in your view.");
        System.out.println("Type 'LOOK' or 'L' to look around\n");
        System.out.println("Type 'GET'+itemName to get the item around you");
        System.out.println("Type 'TRY' to solve the puzzle.");

        System.out.println("Advanced commands(needs to be unlocked):");
        System.out.println("A3 -> left three steps");

    }

    private static void instruct(){
        cls();
        if(beginning&&(boxing(34,40,10,21)))//34,40,7,21
        {if(pos(12, 17)=='X')
        {System.out.println("You wake up in a dark hallway, the wall are made of the stones, the door in front of you is locked, the torch on the wall gives a little light, and when you take a close look on the wall. You find a lot of blood come out from the wall. ");}
        else System.out.println("You come back to the hallway, the torch on the wall seems to be dimmer, the blood dried out. You can only hear the sound of torch burning. There is a horrible smelling of blood in the air.");
        }
        else if(boxing(25,29,11,15)){System.out.println("You meet a huge wall in front of you, you decide to search for the button on it, after a while, you have to take the truth that there is no way to continue going.");}
        //25,29,11,15
        else if(eq(Map.pos, "easter"))System.out.println("You meet a body sitting on the floor, there is none injury on him. You are so confusing what happened to him until find that he have a bag. You open the bag and there is a envelopment for you.");
        else if(eq(Map.pos,"maze")){System.out.println("There are two ways for you, and you could not find out what is behind it. You throw the rock you find in the hallway and there is no danger.");}
        else if(eq(Map.pos,"A shining coin")){System.out.println("You just find out there is a light come from the fork, you think that it is the door to escape, but when you take a close look at it, you find out it is just a shiny coin with an odd mark on it.");}
        else if(eq(Map.pos, "The final door")){System.out.println("You find there is a huge wall in front of you, then you choose knock on it to find if there is more room, and the sound from the knocking give you the answer. You try to find out the button on it, but only thing you find is two keyholes, and there is one circle and rectangle sign on it.");}
        else if(boxing(63, 69, 16, 22)){System.out.println("You opened the door and there is a huge building in it, it is dim and with no sound, you don’t even know what it for, and when you take a close look, you find there is a place to place something on it.");}
        
        else if(eq(Map.pos,"The left guard")){System.out.println("You choose the left door, you see a statue with the face of a cat and a human-like body in front of you, he is holding a huge axe with blood. You can feel something is watching you and when you look at the statue, you find out its eyes are moving, suddenly the statue speak:\"What is the password?\"");}
        else if(eq(Map.pos,"The right guard")){System.out.println("You choose the right door, you see a statue with the face of a cat and a human-like body in front of you, he is holding a huge axe with blood. You can feel something is watching you and when you look at the statue, you find out its eyes are moving, suddenly the statue speak:\"What is the password?\"");}
        else if(pos(37, 10)!='x'&&(boxing(20, 54, 0, 7)||boxing(34, 40, 6, 12))){System.out.println("You finally opened the wall at the other side of the hall way, in front of you is large room and a lot of lantern in the air. By using this light, you find out there is a fountain in the mid of the room, when you take a closer look, you find out there are two statues in front of two doors.");}
        else if(boxing(4, 25, 11, 21)){System.out.println("You are in the maze.");}
        else if(boxing(34, 40, 20, 22)){System.out.println("You found that there are two way: the left passage and the right passage.");}
        else{System.out.println("You found there's one way ahead.");}
    }

    public static char pos(int x,int y){return Main.map[y].charAt(x);}
    public static boolean boxing(int x1,int x2,int y1,int y2){return (Map.x>x1&&Map.x<x2)&&(Map.y>y1&&Map.y<y2);}

    private static void inventory(){
        cls();int i=1,index=-1;
        String[] bag=new String[Inventory.inventory.size()];
        if(Inventory.inventory.isEmpty())System.out.println("Your bag is empty.");
        else for(String a:Inventory.inventory.keySet())
        {
            String key=a.toString();
            bag[i-1]=key;
            String value=Inventory.inventory.get(a).toString();
            System.out.println(i+++": "+key/*+" "+value*/);
        }
        System.out.println("Type the index number of the item to use, or 'B' to go back.");
        Scanner scanItem = new Scanner(System.in);
        if(scanItem.hasNextInt()){
            index = scanItem.nextInt();
            if(index<i){
                if(eq(Map.pos,"The Fountain")&&eq(bag[index-1],"A shining coin")){
                    Inventory.delItem(bag[index-1]);
                    Inventory.addItem("An odd stone");
                    inventory();
                    System.out.println("You put the coin into the fountain, and an odd stone float up. You picked it up, and put it into your bag.");
                }
                else if(eq(Map.pos, "The final altar")&&eq(bag[index-1], "An odd stone")){
                    Inventory.delItem(bag[index-1]);
                    Main.isEnd=true;Main.isWin=true;
                    inventory();
                    System.out.println("You put the odd stone onto the altar, and a strong light beam shines and lighted up the whole chamber. Then, you returned to the real world.");
                }
                else{int k;
                    for(k=0;k<Item.itemList.length;++k){
                        if(eq(Item.itemList[k],bag[index-1]))break;
                    }
                    System.out.println(Item.itemDescrption[k]);
                }
            }
            else{System.out.println("Please use the item that you have.");}
        }
        else if(eq(scanItem.nextLine(),"b")||eq(scanItem.nextLine(),"back")){
            // setMap();
            instruct();
            Main.page="game";
        }
        else{System.out.println("Please type a number.");}
    }

    private static void openDoor(){
        // int[] ans=new int[]{-1,-1,-1,-1};
        // String[] ANS=new String[]{"","","",""};
        if(eq(Map.pos, "The first door")){
            String question = "What is 4595 OR 69?\n";//4599
            if(checkAns(question, 4, 5, 9, 9)){
                remove(37, 10);
                canOpen=false;Map.door1=false;
                Map.pos="origin";
                Main.page="game";
                // setMap();
                instruct();
                System.out.println("That's correct!\nThe lock has been opened.");
            }else{
                // setMap();
                instruct();
                // System.out.println("Sorry, this answer is incorrect, please try again.");
                Main.isEnd=true;
            }
        }
        else if(eq(Map.pos,"lock")){
            String question = "What is 9878 XOR 56?\n";
            
            if(checkAns(question, 9, 9, 0, 6)){//9906
                remove(12, 17);
                canOpen=false;Map.lock=false;
                Map.pos="origin";
                Main.page="game";
                // setMap();
                instruct();
                System.out.println("That's correct!\nThe lock has been opened.");
            }else{
                // setMap();
                instruct();
                // System.out.println("Sorry, this answer is incorrect, please try again.");
                Main.isEnd=true;
            }
            // scanAns.close();
        }
        else if(eq(Map.pos,"The last door")){
            String question = "MTAzMA==\n";
            
            if(checkAns(question, 1, 0, 3, 0)){//1030
                remove(63, 19);
                remove(63, 20);
                canOpen=false;Map.finalDoor=false;
                Map.pos="origin";
                Main.page="game";
                // setMap();
                instruct();
                System.out.println("That's correct!\nThe lock has been opened.");
            }else{
                // setMap();
                instruct();
                // System.out.println("Sorry, this answer is incorrect, please try again.");
                Main.isEnd=true;
            }
            // scanAns.close();
        }
        else if(eq(Map.pos,"The left guard")||eq(Map.pos,"The right guard")){
            String question = "You can't step over this door.";
            System.out.println(question);
        }
    }
    private static boolean checkAns(String q,int a,int b,int c,int d){
        int[] ans=new int[]{-1,-1,-1,-1};
        String[] ANS=new String[]{"","","",""};
        Scanner scanAns = new Scanner(System.in);
        System.out.println(q+"Please enter your answer: _"+ANS[0]+"_ _"+ANS[1]+"_ _"+ANS[2]+"_ _"+ANS[3]+"_");
        int i=0;
        while(i<4){
            if(scanAns.hasNextInt()) {
                ans[i]=scanAns.nextInt()%10;ANS[i]+=ans[i++];
                cls();
                System.out.println(q+"Please enter your answer: _"+ANS[0]+"_ _"+ANS[1]+"_ _"+ANS[2]+"_ _"+ANS[3]+"_");
            }
            else{cls();System.out.println("Please enter a number");checkAns(q, a, b, c, d);}
        }
        return ans[0]==a&&ans[1]==b&&ans[2]==c&&ans[3]==d;
    }

    private static void look(){
        if(eq(Map.pos,"easter")){
            System.out.println("""
            Hello
            I’m Alex.
            
            Joined in the team called golden mystery.
            I am here to tell, the story, that we explored, we been a lot
            Meet the the puzzle that almost eliminate us
            Meet the the maze trapped us,
            Yeah, we aren’t stop and keep exploring, and ......
            
            [Suddenly the paper burns, the fire doesn’t hurt you but shows the color of green.]
            
            Announced by the owner of the hell,
            Named as Santa
            Deal with the duty to kill the invaders, and let me tell you
            
            Quantity people came here to find the opportunities to be rich, they lost their life and soul,
            If they never been, this won’t have.
            Question is are you the same people that focus by the greedy?
            If you want to live or die?
            """);
        }else{
            instruct();
        }
    }
    private static void w(){
        if(Map.y>1&&Main.map[Map.y-1].charAt(Map.x)==' ')
        {remove(Map.x, Map.y);setPos(Map.x, --Map.y);Map.check();}
    }
    private static void s(){
        if(Map.y<Main.LINE-1&&(Main.map[Map.y+1].charAt(Map.x)==' '||isUdLine("s")))
        if(!isOnUd)
        {remove(Map.x, Map.y);setPos(Map.x, ++Map.y);Map.check();}
    }
    private static void a(){
        if(Map.x>1&&Main.map[Map.y].charAt(Map.x-1)==' '||isUdLine("a"))
        {remove(Map.x, Map.y);setPos(--Map.x, Map.y);Map.check();}
    }
    private static void d(){
        if(Map.x<Main.map[Map.y].length()-2&&Main.map[Map.y].charAt(Map.x+1)==' '||isUdLine("d"))
        {remove(Map.x, Map.y);setPos(++Map.x, Map.y);Map.check();}
    }

    private static void w(int n){
        for(int i=0;i<n;++i)
        if(Map.y>1&&Main.map[Map.y-1].charAt(Map.x)==' ')
        {remove(Map.x, Map.y);setPos(Map.x, --Map.y);Map.check();}
    }
    private static void s(int n){
        for(int i=0;i<n;++i)
        if(Map.y<Main.LINE-1&&(Main.map[Map.y+1].charAt(Map.x)==' '||isUdLine("s")))
        if(!isOnUd)
        {remove(Map.x, Map.y);setPos(Map.x, ++Map.y);Map.check();}
    }
    private static void a(int n){
        for(int i=0;i<n;++i)
        if(Map.x>1&&Main.map[Map.y].charAt(Map.x-1)==' '||isUdLine("a"))
        {remove(Map.x, Map.y);setPos(--Map.x, Map.y);Map.check();}
    }
    private static void d(int n){
        for(int i=0;i<n;++i)
        if(Map.x<Main.map[Map.y].length()-2&&Main.map[Map.y].charAt(Map.x+1)==' '||isUdLine("d"))
        {remove(Map.x, Map.y);setPos(++Map.x, Map.y);Map.check();}
    }
    
    private static void openMap(){
        cls();int i;
        int lowMargin=Map.y+Main.VIEW>Main.LINE-2?Main.LINE-2:Map.y+Main.VIEW;
        int leftMargin=Map.x-Main.VIEW<0?0:Map.x-Main.VIEW;
        int rightMargin=Map.x+Main.VIEW>Main.map[0].length()-1?Main.map[0].length()-1:Map.x+Main.VIEW;
        
        int newLine = 1;
        String end = "";
        System.out.print(" ");for(i=0;i<=rightMargin+newLine-leftMargin-1;++i) System.out.print("*");System.out.println();
        // System.out.print(" ");for(i=0;i<=Main.VIEW*2;++i) System.out.print("*");System.out.println();
        for(i=Map.y-Main.VIEW<0?0:Map.y-Main.VIEW;i<=lowMargin;++i){
            // newLine = Main.map[i].substring(Main.map[i].length()-1)=="\n"?1:2;
            rightMargin=Map.x+Main.VIEW>Main.map[i].length()-1?Main.map[i].length()-1:Map.x+Main.VIEW;
            end=Main.map[i].substring(rightMargin);
            System.out.print("*"+Main.map[i].substring(leftMargin, rightMargin+newLine)+"*"/*+(Map.x+Main.VIEW)+" "+rightMargin*/+"\n");
        }
        System.out.print(" ");for(i=0;i<=rightMargin+newLine-leftMargin-1;++i) System.out.print("*");System.out.println();
        // System.out.print(" ");for(i=0;i<=Main.VIEW*2;++i) System.out.print("*");System.out.println();
        // setMap();
    }
    private static void setPos(int x,int y){
        if(Main.map[y].charAt(x)=='_')isOnUd=true;
        else isOnUd=false;
        Main.map[y]=Main.map[y].substring(0, x)+"O"+Main.map[y].substring(x+1);
    }
    private static void setPos(String[] s,int x,int y){}
    private static void remove(int x,int y){
        boolean ud = testUd();
        if(ud) Main.map[y]=Main.map[y].substring(0, x)+"_"+Main.map[y].substring(x+1);
        else Main.map[y]=Main.map[y].substring(0, x)+" "+Main.map[y].substring(x+1);
    }
    private static void remove(int x1,int x2,int y1,int y2){}
    private static void setMap(){int i;
        for(i=0;i<Main.LINE-1;++i) System.out.print(Main.map[i]);
        System.out.println("X:"+Map.x+" Y:"+Map.y+"\t"+Map.pos+"\t"+isOnUd);
        // openMap();
    }
    public static boolean eq(String str,String cmd) {return str.equalsIgnoreCase(cmd);}
    private static void cls(){
        System.out.print(Main.clear);
        // try {Runtime.getRuntime().exec("cls");
        // } catch (IOException e1) { /*改自己的异常类*/e1.printStackTrace();}
    }
    private static boolean isUdLine(String coord){
        if(eq(coord, "a")){return testUd(Map.x-1,Map.y);}
        if(eq(coord, "s")){if(isOnUd) return false; else return testUd(Map.x,Map.y+1);}
        if(eq(coord, "d")){return testUd(Map.x+1,Map.y);}
        return false;
    }
    private static boolean testUd(){
        if(Map.y==12&&(Map.x==7||(Map.x>11&&Map.x<25)))return true;
        if(Map.y==13&&((Map.x>4&&Map.x<8)||(Map.x>14&&Map.x<22)))return true;
        if(Map.y==14&&((Map.x>4&&Map.x<14)||(Map.x>16&&Map.x<22)))return true;
        if(Map.y==15&&((Map.x>6&&Map.x<13)||(Map.x>16&&Map.x<25)))return true;
        if(Map.y==19&&((Map.x>6&&Map.x<11)||(Map.x>13&&Map.x<23)))return true;
        if(Map.y==20&&(Map.x>4&&Map.x<25))return true;
        return false;
    }
    private static boolean testUd(int x,int y){
        if(y==12&&(x==7||(x>11&&x<25)))return true;
        if(y==13&&((x>4&&x<8)||(x>14&&x<22)))return true;
        if(y==14&&((x>4&&x<14)||(x>16&&x<22)))return true;
        if(y==15&&((x>6&&x<13)||(x>16&&x<25)))return true;
        if(y==19&&((x>6&&x<11)||(x>13&&x<23)))return true;
        if(y==20&&(x>4&&x<25))return true;
        return false;
    }
}
