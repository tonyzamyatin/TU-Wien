/*
    Aufgabe 5) Zweidimensionale Arrays - Diverse Methoden
*/

import java.util.Arrays;

public class Aufgabe5 {

    private static int[][] genFilledArray(int n) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int[][] filledArray = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                filledArray[i][j] = j + i;
            }
        }
        return filledArray; //Zeile kann geändert oder entfernt werden.
    }

    private static int[][] extendArray(int[] inputArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int[][] extendedArray = new int[inputArray.length][];
        for (int i = 0; i < inputArray.length; i++) {
            extendedArray[i] = new int[2 * inputArray[i] + 1];  // Es wird ja zweimal i -1 aufgefüllt und das i selbst.
            for (int j = 0; j < extendedArray[i].length; j++) {
                if (j == inputArray[i]) {
                    extendedArray[i][j] = inputArray[i];
                } else {
                    extendedArray[i][j] = -1;
                }
            }
        }
        return extendedArray; //Zeile kann geändert oder entfernt werden.
    }

    private static int[] reformatArray(int[][] inputArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int zeroCount = 0;
        int[] reformatedArray = new int[inputArray.length];
        for (int i = 0; i < reformatedArray.length; i++) {
            zeroCount = 0;
            for (int j = 0; j < inputArray[i].length; j++) {
                if (inputArray[i][j] == 0) {
                    zeroCount++;
                }
            }
            reformatedArray[i] = zeroCount;
        }

        return reformatedArray; //Zeile kann geändert oder entfernt werden.
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                for (int j = 0; j < inputArray[i].length; j++) {
                    System.out.print(inputArray[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                System.out.print(inputArray[i] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] array = genFilledArray(2);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{0, 1}, {1, 2}}));
        System.out.println("-----");

        array = genFilledArray(4);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{0, 1, 2, 3}, {1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}}));
        System.out.println("-----");

        array = genFilledArray(7);
        printArray(array);
        System.out.println("-----");


        int[] array1 = new int[]{4, 0, 5, 2};
        int[][] array1res = extendArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{-1, -1, -1, -1, 4, -1, -1, -1, -1}, {0}, {-1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1}, {-1, -1, 2, -1, -1}}));
        System.out.println("-----");

        array1 = new int[]{0};
        array1res = extendArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{0}}));
        System.out.println("-----");

        array1 = new int[]{0, 1, 2, 1, 0};
        array1res = extendArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{0}, {-1, 1, -1}, {-1, -1, 2, -1, -1}, {-1, 1, -1}, {0}}));
        System.out.println("-----");


        int[][] array2 = new int[][]{{1, 0, 1, 1}, {0, 1, 1}, {0, 1, 0, 1, 1}, {0, 0, 0, 1, 0}, {1, 0}, {1, 1, 1, 1, 1}};
        int[] array2res = reformatArray(array2);
        printArray(array2res);
        assert (Arrays.equals(array2res, new int[]{1, 1, 2, 4, 1, 0}));
        System.out.println("-----");

        array2 = new int[][]{{1, 0, 1, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1}};
        array2res = reformatArray(array2);
        printArray(array2res);
        assert (Arrays.equals(array2res, new int[]{5, 3, 6, 7, 5, 8, 7}));
        System.out.println("-----");
    }
}
