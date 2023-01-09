public class Calculation {
    public static void main(String[] args) {
        int range = 30;     // Start at one and the result of the calculation must be <= 30.
        for (int i = 1; i <= range; i++) {
            for (int j = 1; j <= range; j++) {
                {
                    double c = Math.pow(i, 2) + Math.pow(j, 2);
                    if (Math.sqrt(c) % 1 == 0 && Math.sqrt(c) <= 30) {
                        System.out.printf("a = %d, b = %d, c = %d\n", i, j, (int) Math.sqrt(c));
                    }
                }
            }
        }
    }
}