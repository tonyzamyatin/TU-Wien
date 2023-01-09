/*
    Aufgabe 4) Rekursion
*/
public class Aufgabe4 {

    private static int countNOrderedPairs(String text, int index) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        // Checken ob wir nicht schon am Ende des Strings sind.
        if (index == text.length() - 1) {
            return 0;
        }
        // Checken ob der erste char von text ein Kleinbuchstabe ist.
        if (!"abcdefghijklmnopqrstuvwxyz".contains(text.substring(index, index + 1))) {
            return countNOrderedPairs(text, index + 1);
        }
        // Wenn es ein gültiges Paar ist 1 zurückgeben.
        if (text.charAt(index) <= text.charAt(index + 1)) {
             return 1 + countNOrderedPairs(text, index + 1);
        }
        // Wenn kein gültiges paar, dann weiter mit dem nächsten Paar.
        return countNOrderedPairs(text, index + 1); //Zeile kann geändert oder entfernt werden.
    }

    private static String shiftAllSignsRight(String text, char sign) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        // Wenn sign nicht vorkommt oder der String gleich sign ist den String zurückgeben.
        int index = text.indexOf((sign));
        if (index == -1 || text.equals(Character.toString(sign))) {
            return text;
        }
        // Falls sign am Anfang des Strings steht.
        if (index == 0) {
            return shiftAllSignsRight(text.substring(1), sign) + sign;
        }
        // Falls sign am Ende des Strings steht.
        if (index == text.length() - 1) {
            return text;
        }
        // Linker Teil neben sign + rechter Teil neben sign (kommt nochmal in die Methode rein) + sign
        return text.substring(0,index) + shiftAllSignsRight(text.substring(index + 1), sign) + sign; //Zeile kann geändert oder entfernt werden.
    }

    public static void main(String[] args) {
        String text = "bhhebegcmoqast";
        System.out.println(countNOrderedPairs(text, 0));
        System.out.println(countNOrderedPairs(text, 2));
        System.out.println(countNOrderedPairs(text, 5));
        System.out.println(countNOrderedPairs(text, 6));
        System.out.println(countNOrderedPairs(text, 8));
        System.out.println();

        System.out.println(shiftAllSignsRight("az3kj", 'z'));
        System.out.println(shiftAllSignsRight("kjdn{nd8xngs+d#k", 'n'));
        System.out.println(shiftAllSignsRight("", 'e'));
        System.out.println(shiftAllSignsRight("4", '4'));
        System.out.println(shiftAllSignsRight("ji)o3ie6pk(2i", 'i'));
        System.out.println(shiftAllSignsRight("nothing", 'x'));

        assert (countNOrderedPairs(text, 0) == 9);
        assert (countNOrderedPairs(text, 2) == 7);
        assert (countNOrderedPairs(text, 5) == 6);
        assert (countNOrderedPairs(text, 6) == 5);
        assert (countNOrderedPairs(text, 8) == 4);

        assert (shiftAllSignsRight("az3kj", 'z').equals("a3kjz"));
        assert (shiftAllSignsRight("kjdn{nd8xngs+d#k",'n').equals("kjd{d8xgs+d#knnn"));
        assert (shiftAllSignsRight("", 'e').equals(""));
        assert (shiftAllSignsRight("4", '4').equals("4"));
        assert (shiftAllSignsRight("ji)o3ie6pk(2i", 'i').equals("j)o3e6pk(2iii"));
        assert (shiftAllSignsRight("nothing", 'x').equals("nothing"));
    }
}
