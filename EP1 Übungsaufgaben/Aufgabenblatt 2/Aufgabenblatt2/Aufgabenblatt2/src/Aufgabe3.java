/*
    Aufgabe 3) Verschachtelung von Schleifen und Methoden - Fröhliche Zahlen
*/
public class Aufgabe3 {

    private static boolean isHappyNumber(int number) {
        // number > 0
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        int sum = 0;
        while (true) {
            if (sum != 0) {
                if (sum == 1) {
                    return true;
                } else if (sum == 4) {
                    return false;
                }
                // Werte der Variablen anpassen.
                number = sum;
                sum = 0;
            }
            while (number > 0) {
                sum += Math.pow(number % 10, 2);
                number /= 10;
            }
        }
    }

    private static int countHappyNumbers(int start, int end) {
        // start > 0, end > 0 und start <= end.
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isHappyNumber(i)) {
                count++;
            }
        }
        return count;
    }

    private static void printHappyNumbers(int start, int end) {
        // start > 0, end > 0 und start <= end.
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        for (int i = start; i <= end; i++) {
            if (isHappyNumber(i)) {
                System.out.println(i);
            }
        }


    }

    public static void main(String[] args) {
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE isHappyNumber(...).
        System.out.println("23 --> " + isHappyNumber(23));
        assert (isHappyNumber(23));
        System.out.println("97 --> " + isHappyNumber(97));
        assert (isHappyNumber(97));
        System.out.println("7 --> " + isHappyNumber(7));
        assert (isHappyNumber(7));
        assert (isHappyNumber(1));
        System.out.println("58 --> " + isHappyNumber(58));
        assert (!isHappyNumber(58));
        System.out.println("40 --> " + isHappyNumber(40));
        assert (!isHappyNumber(40));
        System.out.println("5 --> " + isHappyNumber(5));
        assert (!isHappyNumber(5));
        assert (!isHappyNumber(4));
        System.out.println();
        //**********************************************************************

        //TODO: Testen Sie hier alle Methoden mit verschiedenen Inputs!
//        How can I check whether this won't explode?
        int start = 8;
        int end = 15;
        System.out.printf("All the happy numbers in the intervall [%d,%d]:\n", start, end);
        printHappyNumbers(start, end);
        System.out.printf("The number of happy numbers in the intervall [%d,%d]:\n", start, end);
        System.out.println(countHappyNumbers(start, end));

    }
}
