public class Calculation {

    public static void ancientMultiplication(int num1, int num2) {
        int product = 0;
            do {
                if (num1 % 2 != 0) {
                    product += num2;
                }
                num1 /= 2;
                num2 *= 2;
            } while (num1 >= 1);

        System.out.println(product);
    }

    public static void main(String[] args) {
        ancientMultiplication(25, 33);
    }
}
