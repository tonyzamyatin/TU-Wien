/*
    Aufgabe 1) Zweidimensionale Arrays - Diverse Methoden
*/

import java.util.Arrays;

public class Aufgabe1 {

    private static void shiftLines(int[][] workArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        // Implementierung mit "Selection-Sort" am einfachsten, und hat Laufzeit von O(n).
        // Basisfall: Das erste Element des Arrays ist der Array mit dem kleinsten letzten Element.
        int smallArrIndex = 0;
        int smallerArrLength = workArray[0].length;
        // Variable initiiert, die die Länge der Arrays speichert.
        int innerArrLength;
        for (int i = 0; i < workArray.length; i++) {
            innerArrLength = workArray[i].length;
            if (workArray[i][innerArrLength - 1] < workArray[smallArrIndex][smallerArrLength - 1]) {
                smallArrIndex = i;
                smallerArrLength = innerArrLength;
            } else if (workArray[i][innerArrLength - 1] == workArray[smallArrIndex][smallerArrLength - 1]) {
                if(innerArrLength < smallerArrLength) {
                    smallArrIndex = i;
                    smallerArrLength = innerArrLength;
                }

            }
        }
        int[] temp = workArray[smallArrIndex];
        workArray[smallArrIndex] = workArray[0];
        workArray[0] = temp;
    }

    private static void addEntries(int[][] workArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int bigNum;
        for (int i = 0; i < workArray.length; i++) {
            // Die größte Zahl für jede Zeile finden
            bigNum = workArray[i][0];
            for (int j = 1; j < workArray[i].length; j++) {
                bigNum = Math.max(workArray[i][j], bigNum);
            }
            // Neuen Array erstellen mit der länge vom alten Array + die Anzahl der neuen Einträge
            int[] temp = workArray[i];
            workArray[i] = new int[workArray[i].length + bigNum];
            System.arraycopy(temp, 0, workArray[i],0, temp.length);
            for (int j = temp.length; j < workArray[i].length; j++) {
                workArray[i][j] = bigNum;
            }
        }
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                for (int j
                     = 0; j < inputArray[i].length; j++) {
                    System.out.print(inputArray[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Test shiftLines:");
        int[][] array1 = new int[][]{{1, 3, 2}, {6, 2, 5}, {0, 7, 9}};
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{1, 3, 2}, {6, 2, 5}, {0, 7, 9}}));
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][]{{1, 5, 6, 7}, {1, 9, 6}, {4, 3}, {6, 3, 0, 6, 9}, {6, 4, 3}};
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{4, 3}, {1, 9, 6}, {1, 5, 6, 7}, {6, 3, 0, 6, 9}, {6, 4, 3}}));
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][]{{7, 3, 6}, {5}, {9, 1}, {3, 2, 4, 1}, {0}};
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{0}, {5}, {9, 1}, {3, 2, 4, 1}, {7, 3, 6}}));
        printArray(array1);
        System.out.println("-----");

        System.out.println("Test addEntries:");
        int[][] array2 = {{1}, {1, 2}, {1, 2, 3}};
        addEntries(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{1, 1}, {1, 2, 2, 2}, {1, 2, 3, 3, 3, 3}}));
        printArray(array2);
        System.out.println("-----");

        array2 = new int[][]{{3, 4, 2}, {1, 3, 2}, {5, 0, 1}};
        addEntries(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{3, 4, 2, 4, 4, 4, 4}, {1, 3, 2, 3, 3, 3}, {5, 0, 1, 5, 5, 5, 5, 5}}));
        printArray(array2);
        System.out.println("-----");

        array2 = new int[][]{{1, 2}, {1, 2, 4, 3}, {6}, {1, 2, 5, 3, 4}, {1}, {3}};
        addEntries(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{1, 2, 2, 2}, {1, 2, 4, 3, 4, 4, 4, 4}, {6, 6, 6, 6, 6, 6, 6}, {1, 2, 5, 3, 4, 5, 5, 5, 5, 5}, {1, 1}, {3, 3, 3, 3}}));
        printArray(array2);
    }
}

