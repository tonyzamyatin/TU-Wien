/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {

    private static void fillArray(int[] filledArray) {
        int number = 6;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = number;
            number += 6;
        }
    }

    private static void printContentFilteredArray(int[] workArray) {
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 4 == 0) {
                copiedArray[i] = -1;
            }
        }
        printArray(copiedArray);
    }

    private static void fillArrayWithNewContent(int[] workArray) {
        int[] helpArray = new int[10];
        int number = 6;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = number;
            number += 6;
        }
        workArray = helpArray;
        printArray(workArray);
    }

    private static void printArray(int[] workArray) {
        for (int i = 0; i < workArray.length; i++) {
            System.out.print(workArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] filledArray = new int[10];
        fillArray(filledArray);
        printArray(filledArray);

        printContentFilteredArray(filledArray);
        printArray(filledArray);

        filledArray[0] = 777;
        printArray(filledArray);

        fillArrayWithNewContent(filledArray);
        printArray(filledArray);
    }
}

    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************
    //Frage 1:
    // Die Update Vorschrift in der for-Schleife ist "i--".
    // Nach der ersten Iteration ist dann i = -1
    // und man bekommt beim call workArray[i] eine ArrayIndexOutOfBoundsException.
    // Korrektur: i++

    //Frage 2:
    // Man gibt der Methode einen Array, der bereits existiert und die Methode "updatet" dann die Elemente des Arrays.
    // Arrays sind Referenzen und die Elemente vom Array sind mutable (im Gegensatz zu Strings).

    //Frage 3:
    // Die Klasse Array ist ein Referenztyp. Hier wird also nicht der Array "kopiert", sondern nur die Referenz.
    // Eine Kopie von einem Array kann man mit der methode name.clone() oder System.arraycopy(name) erstellen.
    // clone() makes a distinct copy of the first array with its own reference.
    // System.arraycopy() uses JNI (Java Native Interface) to copy an array (or parts of it), so it is blazingly fast;
    // clone() creates a new array with the same characteristics as the old array, i.e., same size, same type, and same contents. Refer to here for some examples of clone in action;
    // manual copying is, well, manual copying. There isn't much to say about this method, except that many people have found it to be the most performant.

    //Frage 4:
    // Die Methode erstellt workArray als eine neue Referenz an den alten Array.
    // Dann erstellen wir einen neuen Array und ändern die Referenz von workArray auf das neue Array.
    // Die Sache ist - workArray ist aber nur das Argument der Methode, und eine andere Referenz als die in main (autonom).
    // Unsere Variable filledArray in main referenziert aber trotzdem noch den alten Array.
    //

    // Zusatzfragen:
    // 1. Der Index muss int sein (bzw. short, int, char).
    // 2. Nein, man kann einen Array auch nur deklarieren z.B. mit int[] arr (die Werte werden mit Standardwerten belegt).
    // 3. Gar nicht. Bei der Initialisierung wird die Länge des Arrays festgelegt, und der Array bekommt eine
    //    bestimmte Zahl an Speicherstellen zugewiesen.
    // 4. Mit der clone-Methode: int[] name = arr.clone().
    // 5. Ja.
    // 6. Bei einem Vergleich zweier Arrays mit "==" wird die Referenz verglichen. Liefert die Methode true,
    //    sind referenzieren die Referenzen denselben Array (d.h. ident). Nicht wirklich zielführend.
    //    Will man dan inhalt vergleichen, dann muss man arr1.equals(arr2) verwenden.
    //    Wenn true, dann sind die Arrays gleich.
