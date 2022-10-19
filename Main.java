import java.util.*;
public class Main{
    public static void main(String[] args){
        welcome();
        Scanner s = new Scanner(System.in);
        String n = new String();
        boolean isRunning = true;
        while(isRunning){
            n=s.nextLine();
            if(n.equalsIgnoreCase("q")){
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
    public static void map(){
        String MAP = new String("");
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