/*
    Aufgabe 3) Verschachtelte Schleifen
*/

public class Aufgabe3 {

    static void printPattern(int height, int pattern) {
        if (height < 1) {
            System.out.println("Please enter a positive number for the height");
        }

        if (pattern < 0 || pattern > 2) {
            System.out.println("Please enter a number between 0 and 2 to chose a pattern");
        }

        String str = "";
        switch (pattern) {
            case 0:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < i; j++) {
                        str += ' ';
                    }
                    str += "*\n";
                }
                break;

            case 1:
                for (int i = 1; i <= height; i++) {
                    for (int j = height - i; j > 0; j--) {
                        str += ' ';
                    }
                    for (int k = 0; k < i; k++) {
                        str += "*";
                    }
                    str += "\n";
                }
                break;

            case 2:
                String width = "";
                for (int i = 0; i < height; i++) {
                    width += '*';
                }
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < i; j++) {
                        str += ' ';
                    }
                    str += width;
                    str += "\n";
                }
                break;

        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        //f Please enter the hight of the pattern:
        int height = 3;
        // Please enter the number of the patter (0 - line, 1 - right triangle, 2 - parallelogram):
        int pattern = 0;
        printPattern(height, pattern);

    }
}
