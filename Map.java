public class Map {
    public static int x,y;
    public static String pos="origin";
    public static void check(){
        if(x==4&&y==14) pos="maze";
        else if((x>34&&x<40)&&(y>10&&y<13)) pos="The first door";
        else if((x>60&&x<63)&&(y>17&&y<22)) pos="The last door";
        
        else if((x>20&&x<28)&&(y>2&&y<7)) pos="The left guard";
        else if((x>46&&x<54)&&(y>2&&y<7)) pos="The right guard";

        else if(checkBox(7, 3)) pos="The left box";
        else if(checkBox(62, 3)) pos="The right box";
        else if(checkBox(16, 16)) pos="The box in the maze";

        else if((x>32&&x<41)&&(y>0&&y<5)) pos="The Fountain";

        else if((x>0&&x<4)&&(y>11&&y<14)) pos="easter";
        else pos="origin";
    }
    public static boolean checkBox(int x1,int y1){
        return (x>x1-1&&x<x1+9)&&(y>y1-1&&y<y1+4);
    }
}