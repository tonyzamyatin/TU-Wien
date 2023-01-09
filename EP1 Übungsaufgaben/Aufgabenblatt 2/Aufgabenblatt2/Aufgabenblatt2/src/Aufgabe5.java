import codedraw.CodeDraw;
import codedraw.Matrix2D;
import codedraw.Palette;

/*
    Aufgabe 5) Designaufgabe
*/
public class Aufgabe5 {

    public static void main(String[] args) {

        //TODO: Implementieren Sie hier Ihre Lösung für die DESIGNAUFGABE
        CodeDraw cd = new CodeDraw(400, 400);
        // Background

        // Set up array for moving stars
        int stars = 25;
        double starX = 400.0;
        double starxY = 400.0;
        int[][] movingStars = new int[stars][2];
        for (int i = 0; i < stars; i++) {
            movingStars[i][0] = (int) (starX * Math.random());
            movingStars[i][1] = (int) (starxY * Math.random());
        }

        // Animate
        while (true) {
            cd.clear();

            // Update star coordinates.
            for (int[] star: movingStars) {
                // Check whether they reached the end of the canvas
                if (star [0] == 0) {
                    star[0] = star[1];
                    star[1] = 0;
                } else if (star[1] == 400) {
                    star[1] = star[0];
                    star[0] = 400;
                } else {
                    star[0]--;
                    star[1]++;
                }
            }

            // Draw dark blue background sky
            cd.setColor(Palette.DARK_SLATE_BLUE);
            cd.fillSquare(0.0, 0.0, 400.0);

            // Draw stars
            cd.setColor(Palette.WHITE);
            for (int[] star : movingStars) {
                cd.fillCircle(star[0], star[1], 1.0);
            }

            // Mars
            cd.setColor(Palette.INDIAN_RED);
            cd.fillCircle(60.0, 50.0, 25.0);

            // Rotate 45°
            cd.setTransformation(Matrix2D.IDENTITY.rotateAt(200.0, 300.0, Math.PI / 4));

            // Rocket body
            cd.setColor(Palette.ALICE_BLUE);
            cd.fillRectangle(110.0, 100.0, 80.0, 200.0);

            // Nose cone
            cd.fillEllipse(150.0, 100.0, 40.0, 80.0);

            // Bottom fins
            cd.setLineWidth(0.5);
            cd.fillTriangle(90.0, 260.0, 110.0, 260.0, 110.0, 230.0);
            cd.drawTriangle(90.0, 260.0, 110.0, 260.0, 110.0, 230.0);
            cd.fillRectangle(90.0, 260.0, 20.0, 30.0);
            cd.drawRectangle(90.0, 260.0, 20.0, 30.0);

            cd.fillTriangle(210.0, 260.0, 190.0, 260.0, 190.0, 230.0);
            cd.drawTriangle(210.0, 260.0, 190.0, 260.0, 190.0, 230.0);
            cd.fillRectangle(190.0, 260.0, 20.0, 30.0);
            cd.drawRectangle(190.0, 260.0, 20.0, 30.0);

            // Top fins
            cd.fillTriangle(90.0, 100.0, 110.0, 100.0, 120.0, 70.0);
            cd.drawTriangle(90.0, 100.0, 110.0, 100.0, 120.0, 70.0);
            cd.fillRectangle(90.0, 100.0, 20.0, 15.0);
            cd.drawRectangle(90.0, 100.0, 20.0, 15.0);

            cd.fillTriangle(210.0, 100.0, 190.0, 100.0, 180.0, 70.0);
            cd.drawTriangle(210.0, 100.0, 190.0, 115.0, 180.0, 70.0);
            cd.fillRectangle(190.0, 100.0, 20.0, 15.0);
            cd.drawRectangle(190.0, 100.0, 20.0, 15.0);

            // Exhaust (299.5 bei y, weil das Drawing-Fenster buggy ist.
            cd.setColor(Palette.DARK_GRAY);
            cd.fillRectangle(125.0, 299.5, 50.0, 10.0);

            // Exhaust gas
            cd.setColor(Palette.fromRGB(234, 158, 55));
            cd.fillTriangle(125.0, 309.0, 175.0, 309.0, 150.0, 434.0);
            cd.setColor(Palette.fromRGB(234, 123, 55));
            cd.fillTriangle(137.0, 309.0, 163.0, 309.0, 150.0, 350.0);

            cd.setTransformation(Matrix2D.IDENTITY.rotateAt(200.0, 300.0, 0));

            // Change the second value to increase or decrease the speed.
            cd.show(1000 / 120);
        }

    }
}
