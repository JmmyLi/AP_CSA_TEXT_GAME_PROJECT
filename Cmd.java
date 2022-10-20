import java.io.IOException;

public class Cmd {
    public static void run(String cmd){
        if(eq(cmd, "help")) help();
        else if(eq(cmd, "inventory")||eq(cmd, "i")) inventory();
        else if(eq(cmd,"look")||eq(cmd, "l")) look();
        else if(eq(cmd, "map")||eq(cmd, "m")) openMap();
        else if(eq(cmd, "w")) w();
        else if(eq(cmd, "s")) s();
        else if(eq(cmd, "a")) a();
        else if(eq(cmd, "d")) d();
    }

    private static void help(){
        System.out.println("Basics:");
        System.out.println("Type W,A,S,D to navigate");
        System.out.println("Type 'inventory' or 'i' to open your bag");
        System.out.println("Type 'map' or 'm' to open your map");
        System.out.println("    -The map will only show the places you have passed.");
        System.out.println("Type 'look' or 'l' to look around");

        System.out.println("Advanced commands(needs to be unlocked):");
        System.out.println("A3 -> left three steps");

    }

    private static void inventory(){

    }
    private static void look(){

    }
    private static void w(){
        if(Map.y>1&Main.map[Map.y-1].charAt(Map.x)==' '){remove(Map.x, Map.y);setPos(Map.x, --Map.y);}
    }
    private static void s(){
        if(Map.y<Main.LINE-1&Main.map[Map.y+1].charAt(Map.x)==' '){remove(Map.x, Map.y);setPos(Map.x, ++Map.y);}
    }
    private static void a(){
        if(Map.x>1&Main.map[Map.y].charAt(Map.x-1)==' '){remove(Map.x, Map.y);setPos(--Map.x, Map.y);}
    }
    private static void d(){
        if(Map.x<Main.map[Map.y].length()-2&Main.map[Map.y].charAt(Map.x+1)==' '){remove(Map.x, Map.y);setPos(++Map.x, Map.y);}
    }
    private static void openMap(){
        cls();
        int i;
        for(i=0;i<Main.LINE-1;++i) System.out.print(Main.map[i]);
    }
    private static void setPos(int x,int y){
        Main.map[y]=Main.map[y].substring(0, x)+"O"+Main.map[y].substring(x+1);
    }
    private static void setPos(String[] s,int x,int y){

    }
    private static void remove(int x,int y){Main.map[y]=Main.map[y].substring(0, x)+" "+Main.map[y].substring(x+1);}
    private static void remove(String[] s,int x,int y){}
    public static boolean eq(String str,String cmd) {return str.equalsIgnoreCase(cmd);}
    private static void cls(){
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException e1) { // 改自己的异常类
            e1.printStackTrace();
        }
    }
}
