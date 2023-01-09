/*
    Aufgabe 2) while-Schleifen
*/
public class Aufgabe2 {

    static void checkForA(String str) {
        String chars = "";
        int i = 1;
        while (i < str.length()) {
                if (str.charAt(i) != 'a') {
                    chars += str.charAt(i);
                }
            i +=2;
        }
        System.out.println(chars);
    }

    static void redundantMethod(String str) {
        int index = -1;
        int i = 0;
        while (index == -1 && i < str.length()) {
            if (str.charAt(i) == 's') {
                index = i;
            }
            i++;
        }
        System.out.println(index);
    }

    static void evenDivBy17(int startExcl, int endExcl) {
        String str = "";
        int i = startExcl + 1;
        while (i < endExcl) {
            if (i % 2 == 0 && i % 17 == 0) {
                str += i;
                if (i != endExcl - 1) {
                    str += " ";
                }
            }
            i++;
        }
        System.out.println(str);
    }

    static void printReverse3es(String str) {
        int i = str.length() - 1;
        int eCounter = 0;
        String reverse = "";
        while (i >= 0 && eCounter < 3) {
            reverse += str.charAt(i);
            if (str.charAt(i) == 'e') {
                eCounter++;
            }
            i--;
        }
        System.out.println(reverse);
    }

    static void countSpacesPunctiuation(String str) {
        int i = 0;
        int counter = 0;
        while (i < str.length()) {
            switch (str.charAt(i)) {
                case ' ', '.', '!' -> counter++;
            }
            i++;
        }
        System.out.println(counter);
    }

    public static void main(String[] args) {

        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        // "text" implimentiert wie in der Angabe... ist aber ein bissl weird.
        String text;
        text = "Wir beginnen am Anfang mit den Grundlagen.";
        String idk = "Kein gesuchtes Zeichen im String!";
        // a)
        checkForA(text);
        checkForA(idk);
        // b)
        redundantMethod(text);
        redundantMethod(idk);
        // c)
        evenDivBy17(17, 238);
        // d)
        printReverse3es(text);
        printReverse3es(idk);
        // e)
        countSpacesPunctiuation(text);
        countSpacesPunctiuation(idk);

    }
}






