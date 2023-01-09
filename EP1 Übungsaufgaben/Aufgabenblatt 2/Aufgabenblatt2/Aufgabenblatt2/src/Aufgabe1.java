/*
    Aufgabe 1) Schleifen - geometrische Formen und Muster (optische Täuschung)
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe1 {

    public static void main(String[] args) {

        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        int ws = 400;
        CodeDraw cd = new CodeDraw(ws, ws);

        // Predefined circle variables
        double r = ws / 60.0;
        double xStartCircle = 2 * r;
        double yStartCircle = 2 * r;
        double space = 4 * r;

        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                // Draw lack filled circles
                cd.setColor(Palette.BLACK);
                cd.fillCircle(xStartCircle + space * col, yStartCircle + space * row, r);
                // Draw gray circles
                cd.setColor(Palette.GRAY);
                cd.setLineWidth(3);
                cd.drawCircle(xStartCircle + space * col, yStartCircle + space * row, r);
            }
        }

        // Predefined big square variables
        double xStartSqaure = 0.25 * ws + r;
        double yStartSqaure = 0.25 * ws + r;
        double side = 0.5 * ws - 2 * r;
        // Draw big white square and black border
        cd.setColor(Palette.WHITE);
        cd.fillSquare(xStartSqaure, yStartSqaure, side);
        cd.setColor(Palette.BLACK);
        cd.setLineWidth(1);
        cd.drawSquare(xStartSqaure, yStartSqaure, side);

        // Predefined small square (squanch) variables
        double xStartSquanch = 0.25 * ws + 2 * r;
        double yStartSquanch = 0.25 * ws + 2 * r;
        double sideSquanch = 2 * r;
        // Draw squanches
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                cd.drawSquare(xStartSquanch + space * col, yStartSquanch + space * row, sideSquanch);
            }
        }

        cd.show();
    }
}
