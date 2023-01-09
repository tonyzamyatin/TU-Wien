public class Maximum {
    public static int maximumOfThree(int a, int b, int c) {
        if (a >= b) {
            if (a >= c) {
                return a;
            } else {
                return c;
            }
        } else if (b >= c) {
            return b;
        }
        return c;
    }

    public static int maximumOfFour(int a, int b, int c, int d) {
        return maximumOfThree(maximumOfThree(a, b, c), a, d);
    }

    public static void main(String[] args) {
        System.out.println(maximumOfThree(5, 8, 7));
        System.out.println(maximumOfFour(4, 6, 3, 1));

    }
}