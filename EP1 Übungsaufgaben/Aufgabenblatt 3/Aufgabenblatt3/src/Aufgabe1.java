/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {
    //TODO zu Punkt a): Beschreiben Sie hier in wenigen Sätzen was der Spaghetticode macht
    //Der Code druckt ein Muster mit einer Breite von 10 Zeichen und einer Länge von 22 Zeile.
    //Es besteht aus jeweils einer Anfangszeile und Endzeile, die gleich aussehen, und dazwischen aus zwei Blöcken, die je 10 Zeilen lang sind.
    //Das Muster wird durch Iteration mit for-Schleifen erzeugt.

    //TODO zu Punkt b): Beschreiben Sie in wenigen Sätzen was Sie ändern würden und warum
    //Oh no ...keine Indents -.- Das musste mit Code reformat mal gescheit formatiert werden - ist ja unerträglich.
    //Die Klammerung ist komplett willkürlich und die Anweisungen gehören auf einzelne Zeile.
    //Würde die for-Schleifen auf jeden Fall mal in Methoden umwandeln.


    //TODO zu Punkt c): Implementieren Sie hier die Methoden Ihrer Lösung
    //Refactor -> Extract Method
    private static void printPatternBlock(int width) {
        for (int i = 1; i < width / 2 + 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.print("\\");
            for (int j = 1; j <= (width - 2 * i); j++) {
                System.out.print("*");
            }
            System.out.print("/");
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < width / 2 + 1; i++) {
            for (int j = 1; j <= (width / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.print("/");
            for (int j = 1; j <= 2 * (i - 1); j++) {
                System.out.print("*");
            }
            System.out.print("\\");
            for (int j = 1; j <= (width / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.println();
        }
    }

    private static void printOrnativeLine(int width) {
        System.out.print("#");
        for (int i = 1; i <= width; i++) {
            System.out.print("|");
        }
        System.out.println("#");
    }

    public static void printPattern(int width) {
        printOrnativeLine(width);
        printPatternBlock(width);
        printPatternBlock(width);
        printOrnativeLine(width);
    }

    public static void main(String args[]) {
        //********************************************************
        //TODO zu Punkt d): Implementieren Sie hier Ihre Lösung für die Angabe
        System.out.println("Ihre Ausgabe:");
        printPattern(10);
        //********************************************************

        System.out.println();
        System.out.println("Ausgabe Spaghetticode:");
        System.out.print("#");
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
        }
        System.out.println("#");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 - 2 * i); j++) {
                System.out.print("*");
            }
            System.out.print("/");
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.print("/");
            for (int j = 1; j <= 2 * (i - 1); j++) {
                System.out.print("*");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 - 2 * i); j++) {
                System.out.print("*");
            }
            System.out.print("/");
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.print("/");
            for (int j = 1; j <= 2 * (i - 1); j++) {
                System.out.print("*");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        System.out.print("#");
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
        }
        System.out.println("#");
    }
}


