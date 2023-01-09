import java.util.Scanner;

public class Triangles {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dashes = 0;

        System.out.println("Eingabe:");
        int num = scanner.nextInt();
        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                for (int j = 0; j < i; j++) {
                    if (j == 0) {
                        System.out.print(i);
                    } else {
                        System.out.print("|" + i);
                    }
                }
                System.out.println();
//                dashes = i == 1 ? 1 : (Integer.toString(i).length() + 1) * i - 1;
                dashes = i == 1 ? 1 : ((int) Math.log10(i) + 2) * i - 1;
                for (int k = 0; k < dashes; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }

    }


}
