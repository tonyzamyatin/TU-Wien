/*
    Aufgabe 5) Schleifen und Zeichnen innerhalb des CodeDraw-Fensters
*/

import codedraw.CodeDraw;
import codedraw.Palette;


public class Aufgabe5 {

    static void drawPattern(int n) {
        // Check input
        if (!(n % 2 == 1 && n >= 5 && n <= 19)) {
            System.out.println("n should be an odd number not smaller than 5, not bigger than 19!");
        } else {
            CodeDraw myDrawObj = new CodeDraw(300, 300);
            double radius = 300.0 / (n * 2.0);

            // Draw red circles.
            myDrawObj.setColor(Palette.RED);
            myDrawObj.setLineWidth(2);
            // Left column of red circles.
            int i = 0;
            while (i < n) {
                // changing centerY -> starts at radius and each iteration adds i diameters.
                myDrawObj.drawCircle(radius, radius + 2 * radius * i, radius);
                // Middle column of red circles
                if (i > 1 && i < n - 2) {
                    // changing centerY -> starts at 2,5 diameters down and each iteration adds (i - 2) diameters,
                    // since i is 2 at the start of this loop.
                    myDrawObj.drawCircle(radius * 5, radius * 5 + 2 * radius * (i - 2), radius);
                }
                i++;
            }

            // Bottom row of red circles.
            i = 0;
            while (i <= n - 1) {
                // changing centerX -> starts at radius and each iteration adds i diameters.
                myDrawObj.drawCircle(radius + 2 * i * radius, 300.0 - radius, radius);
                if (i > 1 && i < n - 2) {
                    // changing centerX -> starts at 2,5 diameters right and each iteration adds (i - 2) diameters,
                    // since i is 2 at the start of this loop.
                    myDrawObj.drawCircle(radius * 5 + 2 * radius * (i - 2), 300.0 - radius * 5, radius);
                }
                i++;
            }

            // Draw blue circles.
            myDrawObj.setColor(Palette.BLUE);
            myDrawObj.setLineWidth(4);
            i = 0;
            // Top row of blue circles.
            while (i < n - 2) {
                // changing centerX -> starts at 1,5 diameters to thr right and each iteration adds i diameters.
                myDrawObj.drawCircle(radius * 3 + 2 * i * radius, radius * 3, radius);
                i++;
            }

            // Bottom row of red circles.
            i = 0;
            while (i <= n - 3) {
                // changing centerY -> starts at 1,5 diameters down and each iteration adds i diameters.
                myDrawObj.drawCircle(300.0 - radius * 3, radius * 3 + 2 * radius * i, radius);
                i++;
            }


            myDrawObj.show();
        }

    }

    public static void main(String[] args) {

        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        drawPattern(9);

    }
}
