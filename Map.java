public class Map {
    public static int x,y;
    public static boolean 
    lock=true,
    letters=true,
    door1=true,
    leftGuard=true,
    finalDoor=true,
    rightGuard=true;
    
    public static String pos="origin";
    public static void check(){
        if(x==4&&y==14) pos="maze";
        else if(x==68&&y==18) pos="The final altar";
        else if((x>7&&x<11)&&(y>16&&y<19)) {pos="letters";Cmd.canGet=true;}

        else if((x>34&&x<40)&&(y>10&&y<12)) {pos="The first door";if(!Cmd.canOpen&&door1){Cmd.canOpen=true;}}
        else if((x>60&&x<63)&&(y>17&&y<22)) {pos="The last door";if(!Cmd.canOpen&&finalDoor){Cmd.canOpen=true;}}
        
        else if((x>20&&x<28)&&(y>2&&y<7)) {pos="The left guard";Cmd.canOpen=true;}
        else if((x>46&&x<54)&&(y>2&&y<7)) {pos="The right guard";Cmd.canOpen=true;}

        else if(checkBox(7, 3)) pos="The left box";
        else if(checkBox(62, 3)) pos="The right box";
        else if(checkBox(16, 16)) pos="The box in the maze";

        else if((x>32&&x<41)&&(y>0&&y<5)) pos="The Fountain";

        else if((x>0&&x<4)&&(y>11&&y<14)) pos="easter";

        else if(x==12&&y==18) {pos="lock";if(!Cmd.canOpen&&lock){Cmd.canOpen=true;}}

        else if(x==6&&y==12) {pos="A shining coin";if(Main.map[12].charAt(5)=='@') Cmd.canGet=true;}
        else {pos="origin";Cmd.canGet=false;Cmd.canOpen=false;}
    }
    public static boolean checkBox(int x1,int y1){
        return (x>x1-1&&x<x1+9)&&(y>y1-1&&y<y1+4);
    }
}