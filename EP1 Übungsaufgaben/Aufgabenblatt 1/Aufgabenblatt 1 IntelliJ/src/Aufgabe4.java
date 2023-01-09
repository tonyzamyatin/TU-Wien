/*
    Aufgabe 4) CodeDraw Bibliothek
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe4 {

    public static void main(String[] args) {

        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        CodeDraw myDrawObj = new CodeDraw(400, 400);

        // Circle with magenta filling
        myDrawObj.setColor(Palette.MAGENTA);
        myDrawObj.fillCircle(100.0, 100.0, 50.0);

        // Circle with cyan
        myDrawObj.setColor(Palette.CYAN);
        myDrawObj.setLineWidth(2);
        myDrawObj.drawCircle(100.0, 100.0, 100.0);

        // Yellow square
        myDrawObj.setColor(Palette.YELLOW);
        myDrawObj.fillSquare(50.0, 250.0, 100.0);

        // Blue diagonals of the yellow square
        myDrawObj.setColor(Palette.BLUE);
        myDrawObj.drawLine(50.0, 250.0, 150.0, 350.0); // diagonal 1
        myDrawObj.drawLine(150.0, 250.0, 50.0, 350.0); // diagonal 2

        // Green lines
        myDrawObj.setColor(Palette.GREEN);
        for (int i = 0; i < 11; i++) {
            if (i < 6) {
                // für die ersten sechs Linien endX pro Schritt  um 40px erhhen.
                myDrawObj.drawLine(200.0, 0.0, 200.0 + 40.0 * i, 400.0);
            } else {
                // ab der sechsten Linie endY beginnend bei 400.0 pro Schritt um 40px verringern.
                // (i - 5), weil ab hier i >= 6, und wie wieder ein i >= 1 brauchen für die Multiplikation mit 40
                myDrawObj.drawLine(200.0, 0.0, 400.0, 400.0 - 40.0 * (i - 5));
            }
        }

        // Red star thingy a.k.a. two overlapping ellipses
        myDrawObj.setColor(Palette.RED);
        myDrawObj.fillEllipse(340.0, 60.0, 60.0, 15.0);
        myDrawObj.fillEllipse(340.0, 60.0, 15.0, 60.0);

        myDrawObj.show();
    }
}
