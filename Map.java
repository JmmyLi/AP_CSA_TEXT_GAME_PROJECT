public class Map {
    public static int x,y;
    public static String pos="origin";
    public static void check(){
        if(x==4&&y==14) pos="maze";
        else if((x>34&&x<40)&&(y>11&&y<13)) pos="The first door";
        else if((x>60&&x<63)&&(y>17&&y<22)) pos="The last door";

        else if((x>0&&x<4)&&(y>11&&y<14)) pos="easter";
        else pos="origin";
    }
}