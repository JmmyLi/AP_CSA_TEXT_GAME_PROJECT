public class Cmd {
    public static void run(String cmd){
        if(eq(cmd, "help")) help();
        else if(eq(cmd, "inventory")||eq(cmd, "i")) inventory();
        else if(eq(cmd,"look")||eq(cmd, "l")) look();
        else if(eq(cmd, "map")||eq(cmd, "m")) map();
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
        System.out.println("W3 -> left three steps");

    }

    private static void inventory(){

    }
    private static void look(){

    }
    private static void w(){

    }
    private static void s(){

    }
    private static void a(){

    }
    private static void d(){

    }
    private static void map(){

    }
    
    public static boolean eq(String str,String cmd) {return str.equalsIgnoreCase(cmd);}
}
