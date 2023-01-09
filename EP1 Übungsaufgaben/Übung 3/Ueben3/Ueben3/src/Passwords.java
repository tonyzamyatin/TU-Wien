import java.util.Scanner;

public class Passwords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String sicher = "Das Passwort ist sicher";
        String unsicher = "Das Passwort ist nicht sicher";

        System.out.println("Geben Sie ein Passwort ein:");
        //
        String pw = scanner.next();

        boolean lang = false;
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        if (pw.length() >= 10) {
            lang = true;
        }
        for (int i = 0; i < pw.length(); i++) {
            if (pw.charAt(i) >= 'a' && pw.charAt(i) <= 'z') {
                lower = true;
            } else if (pw.charAt(i) >= 'A' && pw.charAt(i) <= 'Z') {
                upper = true;
            } else if (pw.charAt(i) >= '0' && pw.charAt(i) <= '9') {
                digit = true;
            }

        }
        System.out.println(upper && lower && digit ? sicher : unsicher);
        if (!lang) {
            System.out.println("* Das Passwort ist zu kurz");
        }
        if (!upper) {
            System.out.println("* Das Passwort enthält keinen Großbuchstaben");
        }
        if (!digit) {
            System.out.println("* Das Passwort enthält keine Ziffer");
        }
    }
}
