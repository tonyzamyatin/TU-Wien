/*
    Aufgabe 2) Erste Methoden
*/
public class Aufgabe2 {

    //TODO: Implementieren Sie hier die in der Angabe beschriebenen Methoden
    // a)
    public static void printChar(char c) {
        System.out.print(c);
    }

    // b)
    public static void printAlphabetPartsReverse(char startChar) {
        if (startChar >= 'a' && startChar <= 'z') {
            printChar(startChar);
            for (int i = startChar - 1; i >= 'a'; i--) {
                System.out.print(" ");
                printChar((char) i);
            }
        }
    }

    // c)
    public static int calcSum(int start, int end) {
        assert start >= 1 && end >= 1 && start <= end;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    // d)
    public static boolean isAsciiValueInRange(char sign, char start, char end) {
        return sign >= start && sign <= end;
    }

    // e)
    public static String removeInString789(String text) {
        assert text != null;
        return text.substring(0, 7);
    }


    public static void main(String[] args) {

        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODEN.
        //ENTFERNEN SIE DIE KOMMENTARE, UM IHRE METHODEN ZU TESTEN.
        assert (calcSum(1, 1) == 1);
        assert (calcSum(1, 3) == 6);
        assert (calcSum(20, 22) == 63);
        assert (calcSum(10, 356) == 63501);

        assert (isAsciiValueInRange('B', 'A', 'G'));
        assert (!isAsciiValueInRange('!', '0', 'Z'));
        assert (isAsciiValueInRange('A', 'A', 'A'));
        assert (isAsciiValueInRange('B', 'A', 'C'));
        assert (isAsciiValueInRange(':', '8', 'D'));
        assert (!isAsciiValueInRange('+', '5', 'A'));
//
        assert (removeInString789("").equals(""));
        assert (removeInString789("7").equals(""));
        assert (removeInString789("67").equals("6"));
        assert (removeInString789("7493").equals("43"));
        assert (removeInString789("Hallo 0123456789:").equals("Hallo 0123456:"));
        assert (removeInString789("Telefonnummer 120, 178 oder 911?").equals("Telefonnummer 120, 1 oder 11?"));
        //**********************************************************************

        //TODO: Testen Sie hier zusätzlich alle Methoden mit verschiedenen Inputs!
    }
}
