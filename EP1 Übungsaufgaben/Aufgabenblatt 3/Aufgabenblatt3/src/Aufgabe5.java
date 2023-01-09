/*
    Aufgabe 5) Kreismuster => Rekursiv vs. Iterativ
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import javax.swing.*;
import java.awt.*;

public class Aufgabe5 {

    private static void drawCirclePatternRecursively(CodeDraw myDrawObj, int x, int y, int r) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        // r > 4, da er im nächsten Schritt halbiert wird und die Voraussetzung ist, dass r > 2 ist.
        if (r > 4) {
            drawCirclePatternRecursively(myDrawObj, x - r, y - r, r / 2);
            drawCirclePatternRecursively(myDrawObj, x - r, y + r, r / 2);
            drawCirclePatternRecursively(myDrawObj, x + r, y - r, r / 2);
            drawCirclePatternRecursively(myDrawObj, x + r, y + r, r / 2);
        }
        myDrawObj.setColor(Palette.ORANGE);
        myDrawObj.fillCircle(x, y, r);
        myDrawObj.setLineWidth(1);
        myDrawObj.setColor(Palette.RED);
        myDrawObj.drawCircle(x, y, r);
    }

    private static void drawCirclePatternIteratively(CodeDraw myDrawObj, int maxRadius) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int layers = (int) (Math.log(maxRadius) / Math.log(2)) - 1;
        // Set starting values for variables.
        int x = 256;
        int y = 256;
        int r = 0;
        int circles = 0;
        // Coordinates of first circle in the top left corner.
        for (int i = 0; i < layers - 1; i++) {
            x -= maxRadius / (Math.pow(2, i));
            y -= maxRadius / (Math.pow(2, i));
        }
        // Draw circles by layer.
        for (int layer = 1; layer <= layers; layer++) {
            r = (int) (Math.pow(2, layer + 1));
            // Set start coordinates for the next layer.
            if (r > 4) {
                x += r;
                y += r;
            }
            // Calculate number of circles in a row/column in the according layer.
            circles = (int) Math.pow(2, 6 - layer);
            for (int row = 0; row < circles; row++) {
                for (int col = 0; col < circles; col++) {
                    // Draw circles and move 4r to the right for every new circle (column) you draw in the row and 4r down for every new row you draw.
                    myDrawObj.setColor(Palette.ORANGE);
                    myDrawObj.fillCircle(x + (4 * r * col), y + (4 * r * row), r);
                    myDrawObj.setLineWidth(1);
                    myDrawObj.setColor(Palette.RED);
                    myDrawObj.drawCircle(x + (4 * r * col), y + (4 * r * row), r);
                }
            }
        }


    }

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        CodeDraw cd = new CodeDraw(512, 512);
        drawCirclePatternRecursively(cd, 256, 256, 128);
        drawCirclePatternIteratively(cd, 128);
        cd.show();
    }
}

    // Zusatzfragen:
    // 1. n-Summe (i = 0) von 4^i, mit n = (int) (ld(r) - 2)
    // 2. 4^n
    // 3. Zeile 19 weglassen

