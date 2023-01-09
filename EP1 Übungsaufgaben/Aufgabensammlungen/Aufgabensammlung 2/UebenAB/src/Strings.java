public class Strings {
    public static String generateString(String first, String second) {
        if (first.length() > second.length()) {
            return first.concat(second);
        } else if (second.length() > first.length()) {
            return second.concat(first);
        }
        return "Teststring";
    }

    public static String mixStrings(String first, String second) {
        if (first.isEmpty() && second.isEmpty()) {
            return "";
        }
        String mix = "";
        int minLength = Math.min(first.length(), second.length());
        String longer = first.length() >= second.length() ? first : second;
        for (int i = 0; i < minLength; i++) {
                mix.concat(String.valueOf(first.charAt(i)));
                mix.concat(String.valueOf(second.charAt(i)));
        }
        mix += longer.substring(minLength);
        return mix;
    }

    public static void main(String[] args) {
        System.out.println(generateString("Hello", "EP1"));
        System.out.println(generateString("Hello", "World!"));
        System.out.println(generateString("Hello", "World"));

        System.out.println(mixStrings("ABCDE", "123"));
        System.out.println(mixStrings("ABC", "1234567"));
        System.out.println(mixStrings("AB", "12"));
        System.out.println(mixStrings("", ""));
    }
}
