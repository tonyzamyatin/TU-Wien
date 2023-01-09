import java.lang.reflect.Array;
import java.util.Arrays;

/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        // a)
        int[] arr1 = new int[]{6, 1, 8, 2, 5, 3, 4, 7, 9, 0};
        System.out.print(arr1[0]);
        for (int i = 1; i < arr1.length; i++) {
            System.out.printf(" %d", arr1[i]);
        }
        System.out.println();

        // b)
        int[] arr2 = new int[12];
        for (int i = 1; i <= arr2.length; i++) {
            arr2[i - 1] = 6 * i;
        }
        System.out.print(arr2[0]);
        for (int i = 1; i < arr2.length; i++) {
            System.out.printf(" %d", arr2[i]);
        }
        System.out.println();

        // c)
        int[] arr3 = new int[]{7, 3, 2, 7, 6, 7, 7, 8, 9, 5};
        int count7 = 0;
        for (int e: arr3) {
            if (e == 7) {
                count7++;
            }
        }
        int len = arr3.length + count7;
        int[] arr4 = new int[len];
        int index = 0;  // erster -1er kann frühstens bei arr4[1] kommen.
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] == 7) {
                arr4[i + index] = 7;
                arr4[i + index + 1] = -1;
                index++;
            } else {
                arr4[i + index] = arr3[i];
            }
        }
        System.out.print(arr4[0]);
        for (int i = 1; i < arr4.length; i++) {
            System.out.printf(" %d", arr4[i]);
        }
        System.out.println();

        // d)
        int[] arr5 = new int[11];
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = i + 1;
        }
        // for Schleife
        System.out.printf("for-Schleife: %d", arr5[arr5.length - 1]);
        for (int i = arr5.length - 2; i >= 0; i--) {
            System.out.printf(" ,%d", arr5[i]);
        }
        //new line
        System.out.println();
        // while-Schleife
        System.out.printf("while-Schleife: %d", arr5[arr5.length -1]);
        int i = arr5.length - 2;
        while (i >= 0) {
            System.out.printf(" ,%d", arr5[i]);
            i--;
        }
    }
}

