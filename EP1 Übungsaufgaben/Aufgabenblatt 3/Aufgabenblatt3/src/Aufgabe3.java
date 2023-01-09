/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static void printEvenNumbersAscending(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (start % 2 == 0) {
            System.out.println(start);
            if (start + 2 <= end) {
                printEvenNumbersAscending(start + 2, end);
            }
        } else if (start + 1 <= end) {
            printEvenNumbersAscending(start + 1, end);
        }
    }

    private static void printOddNumbersDescending(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (end % 2 == 1) {
            System.out.println(end);
            if (end - 2 >= start) {
                printOddNumbersDescending(start, end - 2);
            }
        } else if (end - 1 >= start) {
            printOddNumbersDescending(start, end - 1);
        }
    }

    private static int sumSquaredDigits(int number) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        //Endpunkt der Rekursion, wenn number == 0.
        if (number == 0) {
            return 0;
        }
        return (int) Math.pow((number % 10), 2) + sumSquaredDigits(number / 10); //Zeile kann geändert oder entfernt werden.
    }

    private static String removeSpaces(String text) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (!text.contains(" ")) {
            return text;
        }
        if (text.equals(" ")) {
            return "";
        }
        if(text.charAt(0) == ' ') {
            return removeSpaces(text.substring(1));
        }
        return text.substring(0, text.indexOf(' ')) + removeSpaces(text.substring(text.indexOf(' '))); //Zeile kann geändert oder entfernt werden.
    }

    public static void main(String[] args) {
        printEvenNumbersAscending(10, 20);
        System.out.println();
        printOddNumbersDescending(5, 15);
        System.out.println();

        System.out.println("hello".substring(4));

        System.out.println(sumSquaredDigits(1));
        System.out.println(sumSquaredDigits(102));
        System.out.println(sumSquaredDigits(1234));
        System.out.println(sumSquaredDigits(10000));
        System.out.println(sumSquaredDigits(93842));
        System.out.println(sumSquaredDigits(875943789));
        assert (sumSquaredDigits(1) == 1);
        assert (sumSquaredDigits(102) == 5);
        assert (sumSquaredDigits(1234) == 30);
        assert (sumSquaredDigits(10000) == 1);
        assert (sumSquaredDigits(93842) == 174);
        assert (sumSquaredDigits(875943789) == 438);
        System.out.println();

        System.out.println(removeSpaces(" "));
        System.out.println(removeSpaces("+ +"));
        System.out.println(removeSpaces(" 12 3 45 "));
        System.out.println(removeSpaces("a  b   c    d"));
        assert (removeSpaces(" ").equals(""));
        assert (removeSpaces("+ +").equals("++"));
        assert (removeSpaces(" 12 3 45 ").equals("12345"));
        assert (removeSpaces("a  b   c    d").equals("abcd"));
    }
}

