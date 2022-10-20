import java.io.IOException;
import java.io.InputStream;
import java.util.*;
public class Main{
    final static int LINE = 23;
    public static String page = "welcome";
    public static String[] map = new String[LINE];
    static int i,j,k;
    public static void main(String[] args){
        for(i=0;i<LINE-1;++i) map[i]="";
        getMap();
        welcome();
        Scanner s = new Scanner(System.in);
        String n = new String();
        boolean isRunning = true;
        while(isRunning){
            n=s.nextLine();
            if(Cmd.eq(n, "q")){
                System.out.println("Do you really want to quit?(Y/N)");
                n=s.nextLine();
                if(n.equalsIgnoreCase("y")||n.equalsIgnoreCase("q")){System.out.println("Hope to see you again!");isRunning=false;break;}
            }else{
                Cmd.run(n);
            }
            
        }
        s.close();
    }
    public static void welcome()
    {
        System.out.println("Welcome to the Horre-4/3 Land!");
        System.out.println("type 'help' to learn more");
    }
    public static void getMap(){
        // FileInputStream fin = new FileInputStream("map.txt");
        InputStream fin = Main.class.getResourceAsStream("map.txt");
        byte[] bytes = new byte[2];
        int len = 0;i=0;
        try {
            while((len=fin.read(bytes)) != -1){
                String pt = new String(bytes,0,len);
                map[i]+=pt;
                // System.out.print(pt);
                if(pt.equals("\n")) {System.out.println(map[i++]);}
                if(pt.equals("O")) {Map.x=map[i].indexOf(pt); Map.y=i;}
                // else map[i]+=pt;
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