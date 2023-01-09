/*
    Aufgabe 2) Zweidimensionale Arrays - Sortieren und Filtern
*/
public class Aufgabe2 {

    private static double[][] genCircleFilter(int n, double radius) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        // Überprüfen ob Eingabewert gerade ist.
        if (n % 2 == 0 || n < 1) {
            return null;
        }
        double[][] filter = new double[n][n];
        int center = (n / 2);
        for (int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                // Überprüfen, ob das Element innerhalb des Radius liegt mit der Formel sqrt(∆x^2 + ∆y^2).
                if(Math.sqrt(Math.pow(y - center, 2) + Math.pow(x - center, 2)) < radius) {
                    filter[y][x] = 1.00;
                } else {
                    filter[y][x] = 0.00;
                }
            }
        }
        return filter; //Zeile kann geändert oder entfernt werden.
    }

    private static double[][] applyFilter(double[][] workArray, double[][] filterArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int center = filterArray.length / 2;            // Mitte von filterArray, gleichzeitig erste x und y bei dem filterArray reinpasst.
        int endY = (workArray.length) - center;         // Erstes y bei dem filterArray unten Überhang hat.
        int endX = (workArray[0].length) - center;      // Erstes x bei dem filterArray rechts Überhang hat.
        double filterSum = 0;                           // Summe vom Overlay mit filterArray -> wird geupdatet.
        // Neues Array mit den Dimensionen und Längen von workArray erstellen.
        double[][] newArray = new double[workArray.length][workArray[0].length];
        // wir iterieren jetzt den Teil von newArray durch, bei dem das Overlay keinen Überhang hat.
        for (int y = center; y < endY; y++) {
            for (int x = center; x < endX; x++) {
                // Hier berechnen wir die Summe für jeden Punkt in newArray, bei dem das Overlay passt.
                for (int i = 0; i < filterArray.length; i++) {
                    for (int j = 0; j < filterArray[0].length; j++) {
                        // Ein Workaround, war hier nötig weil sich ja auch die Koordinaten in workArray mitverschieben.
                        // (y - center) ist der Abstand unten und oben, und (x - center) links und rechts.
                        filterSum += workArray[i + (y - center)][j + (x - center)] * filterArray[i][j];
                    }
                }
                newArray[y][x] = filterSum;
                filterSum = 0;
            }
        }
        return newArray; //Zeile kann geändert oder entfernt werden.
    }


    private static void print(double[][] workArray) {
        if (workArray != null) {
            for (int y = 0; y < workArray.length; y++) {
                for (int x = 0; x < workArray[y].length; x++) {
                    System.out.printf("%.2f", workArray[y][x]);
                    System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] myResultArray;

        double[][] myFilter1 = genCircleFilter(3, 1.2);
        System.out.println("Output -> myFilter1 (genCircleFilter mit size = 3 und radius = 1.2):");
        print(myFilter1);

        double[][] myFilter2 = genCircleFilter(7, 2.5);
        System.out.println("Output -> myFilter2 (genCircleFilter mit size = 7 und radius = 2.5):");
        print(myFilter2);

        double[][] myArray1 = {{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 2, 2, 2, 0}, {0, 3, 3, 3, 0}, {0, 0, 0, 0, 0}};
        System.out.println("Output -> myArray1:");
        print(myArray1);

        myResultArray = applyFilter(myArray1, myFilter1);
        System.out.println("Output -> myFilter1 applied to myArray1:");
        print(myResultArray);

        myResultArray = applyFilter(myArray1, myFilter2);
        System.out.println("Output -> myFilter2 applied to myArray1:");
        print(myResultArray);

//        Beispiel aus Aufgabenblatt
        double[][] myArray3 = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        double[][] myFilter3 = {{1, 0, 0}, {1, 2, 0}, {0, 0, 3}};
        System.out.println("Output -> myArray3:");
        print(myArray3);
        System.out.println("Output -> myFilter3:");
        print(myFilter3);
        myResultArray = applyFilter(myArray3, myFilter3);
        System.out.println("Output -> myFilter3 applied to myArray3:");
        print(myResultArray);

        double[][] myArray4 = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 2, 3, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println("Output -> myArray4:");
        print(myArray4);
        //TODO: Erstellen Sie den Filter aus dem Aufgabenblatt, wenden Sie ihn auf myArray4 an und geben Sie das Ergebnis mittels print() aus
        double[][] myFilter4 = new double[3][3];
        myFilter4[2][1] = 0.5;
        System.out.println("Output -> myFilter4:");
        print(myFilter4);
        myResultArray = applyFilter(myArray4, myFilter4);
        System.out.println("Output -> myFilter4 applied to myArray4:");
        print(myResultArray);
    }


}
