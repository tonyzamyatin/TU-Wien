/*
    Aufgabe 1) for-Schleifen
*/
public class Aufgabe1 {

    static void sumDivBy17(int startIncl, int endIncl) {
        int sum = 0;
        for (int i = startIncl; i <= endIncl; i++) {
            if (i % 17 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    static void multiplesOf6(int startIncl, int endIncl) {
        String str = Integer.toString(startIncl);
        for (int i = startIncl; i <= endIncl; i += 6) {
                str += " " + i;
        }
        System.out.println(str);
    }

    static void divBy9and13(int startExcl, int endExcl) {
        String str = "+";
        for (int i = startExcl + 1; i < endExcl; i++) {
            if (i % 9 == 0 && i % 13 == 0) {
                str += i;
                str += "+";
            }
        }
        System.out.println(str);
    }

    static void charsToInt(char startExcl, char endIncl) {
        String str = "";
        for (char i = endIncl; i > startExcl; i--) {
            str += i;
            str += " ";
        }
        System.out.println(str);
    }

    static void countE(String str) {
        int count = 0;
        char[] chars = str.toCharArray();
        for (char e : chars) {
            if (e == 'e' || e == 'E') {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        // a)
        sumDivBy17(17, 170);
        // b)
        multiplesOf6(60, 82);
        // c)
        divBy9and13(117, 585);
        // d)
        charsToInt((char) 45, (char) 65);
        // e)
        countE("Es ist kein echtes Edelmetall!");
    }
}
