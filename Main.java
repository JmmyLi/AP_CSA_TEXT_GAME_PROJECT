import java.io.IOException;
import java.io.InputStream;
import java.util.*;
public class Main{
    final static int LINE = 24;
    final static int VIEW = 3;
    public static String page = "welcome";
    public static String[] map = new String[LINE];
    public static String clear = "";
    static int i,j,k;
    public static boolean isWin = false,isEnd = false;
    public static void main(String[] args){
        for(i=0;i<50;++i)clear+="\n";
        for(i=0;i<LINE-1;++i) map[i]="";
        getMap();
        System.out.println("X:"+Map.x+" Y:"+Map.y);
        welcome();
        Scanner s = new Scanner(System.in);
        String n = new String();
        boolean isRunning = true;
        while(isRunning){
            if(isEnd){
                if(isWin) System.out.println("You place odd stone on it, the sacrificial altar suddenly turned up, and spreading out the blue light, this light covers you, you feel it is so warm. ------------------------------ This is the end of the game, congratulation! Thanks for playing our game.");
                else System.out.println("Sorry, you lose the game, You will be trapped in this creepy place forever.");
                isRunning=false;break;
            }
            n=s.nextLine();
            if(Cmd.eq(n, "q")){
                System.out.println("Do you really want to quit?(Y/N)");
                n=s.nextLine();
                if(Cmd.eq(n, "y")||Cmd.eq(n, "q")){System.out.println("Hope to see you again!");isRunning=false;break;}
            }
            else if(isEnd){
                if(isWin) System.out.println("You place odd stone on it, the sacrificial altar suddenly turned up, and spreading out the blue light, this light covers you, you feel it is so warm. ------------------------------ This is the end of the game, congratulation! Thanks for playing our game.");
                else System.out.println("Sorry, you lose the game, You will be trapped in this creepy place forever.");
                isRunning=false;break;
            }
            else{
                Cmd.run(n);
            }
            
        }
        s.close();
        
    }
    public static void welcome()
    {
        System.out.println("\n\n						Welcome to the Horre-4/3 Land!");
        System.out.println("\n\n						  type 'help' to learn more");
        page = "game";
    }
    public static void getMap(){
        // FileInputStream fin = new FileInputStream("map.txt");
        InputStream fin = Main.class.getResourceAsStream("map.txt");
        byte[] bytes = new byte[1];
        int len = 0;i=0;
        try {k=0;
            while((len=fin.read(bytes)) != -1){
                String pt = new String(bytes,0,len);
                map[i]+=pt;
                // System.out.print(pt);
                if(pt.equals("\n")) {System.out.print(map[i++]);}
                if(pt.equals("O")) {Map.x=map[i].indexOf(pt); Map.y=i;}
                if(pt.equals("_")) {}
                // else map[i]+=pt;
                // System.out.print("$"+pt);
                k++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // System.out.println(inputStream);
    }
}
/*
_____________________________________________________________________________
|                                                                            |
|                                                                            |
|                                                                            |
|                                                                            |
|                                                                            |
|                                                                            |
|                                                                            |
|                                                                            |
|                                                                            |
|                                     O                                      |
|                                                                            |
|                                                                            |
|                                                                            |
|                                                                            |
|                                                                            |
|                                                                            |
|                                                                            |
|                                                                            |
|                                                                            |
------------------------------------------------------------------------------

*/