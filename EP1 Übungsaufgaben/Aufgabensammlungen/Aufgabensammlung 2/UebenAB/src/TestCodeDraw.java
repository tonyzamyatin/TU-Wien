import codedraw.*;

public class TestCodeDraw {
    public static void main(String[] args) {
        //"Hello World!" einmal anders.
        int width = 300;
        int height = 100;
        int x = 0, x_start = -90;

        CodeDraw cd = new CodeDraw(width, height);
        cd.setTitle("\"Test CodeDraw\"");

        while (true) {
            cd.clear();
            if(x == width){
                x = x_start;
            }
            else{
                x++;
            }
            cd.drawText(x, height / 2.0, "CodeDraw works!");
            cd.show(10);
        }
    }
}
