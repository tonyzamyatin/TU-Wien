import java.util.Arrays;

public class K3_Test {

    private static int[][] labelPath(int n, int[][] points) {
        int[][] arr = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                arr[row][col] = n;
            }
        }
        for (int[] point : points) {
            arr[point[0]][point[1]] = -1;
        }
        return arr;
    }

    private static void findMatches(int[][] data, int[] pattern, int[] target) {
        for (int i = 0; i < data.length; i++) {
            if (pattern.length <= data[i].length) {
                for (int j = 0; j < data[i].length - pattern.length; j++) {
                    
                }
            }
        }
    }

    private static String insertMiddle(String input, String seps) {
        return null;
    }
    public static void main(String[] args) {
        int[][] data0 = {{3, 0}, {0, 1}, {2, 2}};
        int[][] data1 = {{0, 1, 0, 0, 1, 0}, {}, {2, 2, 2, 2, 0, 1}};
        int[] pattern1 = {0, 1};
        int[] target1 = {0, 0, 0};
        int[] target2 = {9, 9, 9, 9};

        int[][] LabData0 = labelPath(4, data0);
        System.out.println(Arrays.deepToString(LabData0));
        findMatches(data1, pattern1, target1);
        System.out.println(Arrays.toString(target1));
    }
}
