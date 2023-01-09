/*
    Aufgabe 3) Zweidimensionale Arrays und CodeDraw - Bildverarbeitung "Finding Waldo"
*/

import codedraw.CodeDraw;
import codedraw.Palette;
import codedraw.Image;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Aufgabe3 {

    // converts RGB image into a grayscale array
    private static int[][] convertImg2Array(Image img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[][] imgArray = new int[height][width];
        Color tempColor;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                tempColor = img.getPixel(col, row);
                imgArray[row][col] = (int) (tempColor.getRed() * 0.3 + tempColor.getGreen() * 0.59 + tempColor.getBlue() * 0.11);
            }
        }
        return imgArray;
    }

    //detect waldo by template matching
    private static void detectWaldo(CodeDraw myDrawObj, Image img, Image template) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int[][] imgArr = convertImg2Array(img);
        int[][] templateArr = convertImg2Array(template);
        myDrawObj.setLineWidth(6);
        myDrawObj.setColor(Palette.DEEP_PINK);
        // 1) Wir gehen jetzt mit dem templateArr durch imgArr durch,
        // 2) berechnen die SAD und
        // 3) zeichnen immer, wenn eine neue minSAD gefunden wird.
        int startY = templateArr.length / 2;           // Mittelpunktes vom template (y-Wert), gleichzeitig Startwert für Suche.
        int startX = templateArr[0].length / 2;        // Mittelpunktes vom template (x-Wert), gleichzeitig Startwert für Suche.
        int endY = imgArr.length - startY;             // Ende der Suche in img (y-Wert).
        int endX = imgArr[0].length - startX;          // Ende der Suche in img (x-Wert).
        int minSAD = -1;
        int currentSAD = 0;
        for (int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                // Hier berechnen wir die Summe für jeden Punkt in newArray, bei dem das Overlay passt.
                for (int i = 0; i < templateArr.length; i++) {
                    for (int j = 0; j < templateArr[0].length; j++) {
                        // Ein Workaround, war hier nötig weil sich ja auch die Koordinaten in workArray mitverschieben.
                        // (y - center) ist der Abstand unten und oben, und (x - center) links und rechts.
                        currentSAD += Math.abs(imgArr[i + (y - startY)][j + (x - startX)] - templateArr[i][j]);
                    }
                }
                if(minSAD < 0 || currentSAD < minSAD) {
                    minSAD = currentSAD;
                    myDrawObj.clear();
                    myDrawObj.drawImage(0, 0, img);
                    myDrawObj.drawRectangle(x - startX, y - startY, templateArr[0].length, templateArr.length);
                    myDrawObj.show(300);
                }
                currentSAD = 0;
            }
        }
        System.out.println("Finished!");
    }

    public static void main(String[] args) {

        //waldo1
//        String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/6NcsuQdriPbHcKN/download"; //waldo1.png
//        String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/AwlmIBqj2V1qGV7/download"; //template1.png

        //waldo2
//        String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/922nyXVsBkMKz6K/download"; //waldo2.png
//        String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/tqTFXxF2BkeKnhm/download"; //template2.png

        //waldo3
        String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/DR2u4Xf5muAZsWo/download"; //waldo3.png
        String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/xEMZlbdHJ4ZfLfz/download"; //template3.png

        // open image file
        Image img = Image.fromUrl(linkWaldo);

        // open template image file
        Image template = Image.fromUrl(linkTemplate);

        // set StdDraw window size based on the image size
        int width = img.getWidth();
        int height = img.getHeight();
        CodeDraw cd = new CodeDraw(width, height);

        //draw image
        cd.drawImage(0, 0, img);
        cd.show();

        //detect Waldo given in 'template' and show result in image 'img'
        detectWaldo(cd, img, template);
    }
}





