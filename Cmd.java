public class Cmd {
    public static void run(String cmd){
        if(eq(cmd, "help")) help();
        else if(eq(cmd, "inventory")||eq(cmd, "i")) inventory();
    }

    private static void help(){
        System.out.println("Type W,A,S,D to navigate");
        System.out.println("Type 'inventory' or 'i' to open your bag");
        System.out.println("Type 'map' or 'm' to open your map");
        System.out.println("    -The map will only show the places you have passed.");
        System.out.println("Type 'look' or 'l' to look around");
    }

    private static void inventory(){
        
    }
    
    public static boolean eq(String str,String cmd) {return str.equalsIgnoreCase(cmd);}
}
