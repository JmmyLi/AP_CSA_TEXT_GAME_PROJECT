import java.io.IOException;

public class Cmd {
    public static void run(String cmd){
        int csize=cmd.length();
        String one=new String();
        if(csize>0) {one+=cmd.charAt(0);}
        
        if(eq(cmd, "help")) {help();Main.page=cmd;}
        else if(eq(cmd, "i")|eq(cmd, "inventory")) {inventory();Main.page=cmd;}
        else if(eq(cmd, "l")|eq(cmd,"look")) look();
        else if(eq(cmd, "m")|eq(cmd, "map")) {openMap();Main.page=cmd;}
        else if(eq(one, "w")) {if(csize==1)w();else w(cmd.charAt(1)-'0');setMap();}
        else if(eq(one, "s")) {if(csize==1)s();else s(cmd.charAt(1)-'0');setMap();}
        else if(eq(one, "a")) {if(csize==1)a();else a(cmd.charAt(1)-'0');setMap();}
        else if(eq(one, "d")) {if(csize==1)d();else d(cmd.charAt(1)-'0');setMap();}
        if(eq(cmd, "b")|eq(cmd,"back")) {Main.page="game";cls();}
        else if(!Main.page.equals("game")) System.out.println("Type 'BACK' or 'b' back to the main game");
        Map.check();
    }

    private static void help(){
        cls();
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
    private static void w(int n){
        for(int i=0;i<n;++i)if(Map.y>1&Main.map[Map.y-1].charAt(Map.x)==' '){remove(Map.x, Map.y);setPos(Map.x, --Map.y);}
    }
    private static void s(){
        if(Map.y<Main.LINE-1&Main.map[Map.y+1].charAt(Map.x)==' '){remove(Map.x, Map.y);setPos(Map.x, ++Map.y);}
    }
    private static void s(int n){
        for(int i=0;i<n;++i)if(Map.y<Main.LINE-1&Main.map[Map.y+1].charAt(Map.x)==' '){remove(Map.x, Map.y);setPos(Map.x, ++Map.y);}
    }
    private static void a(){
        if(Map.x>1&Main.map[Map.y].charAt(Map.x-1)==' '){remove(Map.x, Map.y);setPos(--Map.x, Map.y);}
    }
    private static void a(int n){
        for(int i=0;i<n;++i)if(Map.x>1&Main.map[Map.y].charAt(Map.x-1)==' '){remove(Map.x, Map.y);setPos(--Map.x, Map.y);}
    }
    private static void d(){
        if(Map.x<Main.map[Map.y].length()-2&Main.map[Map.y].charAt(Map.x+1)==' '){remove(Map.x, Map.y);setPos(++Map.x, Map.y);}
    }
    private static void d(int n){
        for(int i=0;i<n;++i)if(Map.x<Main.map[Map.y].length()-2&Main.map[Map.y].charAt(Map.x+1)==' '){remove(Map.x, Map.y);setPos(++Map.x, Map.y);}
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
    private static void setMap(){int i;
        for(i=0;i<Main.LINE-1;++i) System.out.print(Main.map[i]);
        System.out.println("X:"+Map.x+" Y:"+Map.y+"\t"+Map.pos);
    }
    public static boolean eq(String str,String cmd) {return str.equalsIgnoreCase(cmd);}
    private static void cls(){
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException e1) { // 改自己的异常类
            e1.printStackTrace();
        }
    }
}
