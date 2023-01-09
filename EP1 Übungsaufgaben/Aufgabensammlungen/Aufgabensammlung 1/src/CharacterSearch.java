public class CharacterSearch {
    public static String countChar(String text, char c) {
        int count = 0;
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == c) {
                count++;
            }
        }
        if (count >= 2) {
            return "Zwei oder mehr Zeichen gefunden";
        } else if (count == 1) {
            return "Genau ein Zeichen gefunden";
        }
        return "Kein Zeichen gefunden";
    }

    public static void main(String[] args) {
        System.out.println(countChar("Schneeeulen" , 'a'));
        System.out.println(countChar("Schneeeulen" , 'u'));
        System.out.println(countChar("Schneeeulen" , 'e'));

    }
}