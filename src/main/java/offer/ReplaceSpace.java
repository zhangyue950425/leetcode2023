package offer;

/**
 * 05
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace(s));
    }
}
