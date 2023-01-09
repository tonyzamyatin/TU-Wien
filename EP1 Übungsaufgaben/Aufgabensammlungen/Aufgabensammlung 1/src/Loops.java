public class Loops {

    public static void sumDivisors(int start, int end, int[] divisors) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            for (int e : divisors) {
                if (i % e == 0) {
                    sum += i;
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    public static void printNums(int start, int end) {
        for(int i = start; i <= end; i++) {
            if ((i) - start % 3 == 0) {
                System.out.printf("%d=%c",i,'*');
            } else {
                System.out.printf("%d=", i);
            }
        }
        System.out.println();
    }

    public static void removeHashtag(String text) {
        System.out.println(text.replace("#", ""));
    }

    public static void main(String[] args) {
        System.out.println();
        sumDivisors(13, 68, new int[] {4, 7});
        printNums(10, 20);
        removeHashtag("#Wichtige #Nachricht erhalten##");
    }
}
