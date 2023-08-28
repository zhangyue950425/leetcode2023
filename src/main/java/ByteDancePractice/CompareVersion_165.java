package ByteDancePractice;

public class CompareVersion_165 {

    public int compareVersion(String version1, String version2) {
        int length1 = version1.length();
        int length2 = version2.length();
        int index1 = 0, index2 = 0;
        while (index1 < length1 || index2 < length2) {
            int num1 = 0;
            for (; index1 < length1 && version1.charAt(index1) != '.'; index1++) {
                num1 = num1 * 10 + version1.charAt(index1) - '0';
            }
            index1++;
            int num2 = 0;
            for (; index2 < length2 && version2.charAt(index2) != '.'; index2++) {
                num2 = num2 * 10 + version2.charAt(index2) - '0';
            }
            index2++;
            if (num1 != num2) {
                return num1 > num2 ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersion_165 compareVersion_165 = new CompareVersion_165();
        String version1 = "1.01";
        String version2 = "1.001";
        System.out.println(compareVersion_165.compareVersion(version1, version2));
        version1 = "1.0";
        version2 = "1.0.0";
        System.out.println(compareVersion_165.compareVersion(version1, version2));
        version1 = "1.0";
        version2 = "1.0.1";
        System.out.println(compareVersion_165.compareVersion(version1, version2));
        version1 = "0.1";
        version2 = "1.1";
        System.out.println(compareVersion_165.compareVersion(version1, version2));
    }
}
