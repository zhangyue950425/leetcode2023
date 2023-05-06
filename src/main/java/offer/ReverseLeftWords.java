package offer;

public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < length; i++) {
            stringBuilder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        ReverseLeftWords reverseLeftWords = new ReverseLeftWords();
        System.out.println(reverseLeftWords.reverseLeftWords(s, n));
        s = "lrloseumgh";
        n = 6;
        System.out.println(reverseLeftWords.reverseLeftWords(s, n));
    }
}
