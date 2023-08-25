package ByteDancePractice;

public class AddStrings_415_2 {

    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        int index1 = length1 - 1;
        int index2 = length2 - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index1 >= 0 || index2 >= 0) {
            int n1 = 0;
            int n2 = 0;
            if (index1 >= 0) {
                n1 = chars1[index1] - '0';
            }
            if (index2 >= 0) {
                n2 = chars2[index2] - '0';
            }
            int result = n1 + n2 + carry;
            if (result >= 10) {
                carry = result / 10;
                stringBuilder.insert(0, result % 10);
            } else {
                carry = 0;
                stringBuilder.insert(0, result);
            }
            index1--;
            index2--;
        }
        if (carry > 0) {
            stringBuilder.insert(0, carry);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        AddStrings_415_2 addStrings_415_2 = new AddStrings_415_2();
        String num1 = "11";
        String num2 = "123";
        System.out.println(addStrings_415_2.addStrings(num1, num2));
        num1 = "456";
        num2 = "77";
        System.out.println(addStrings_415_2.addStrings(num1, num2));
        num1 = "0";
        num2 = "0";
        System.out.println(addStrings_415_2.addStrings(num1, num2));
        num1 = "123456789";
        num2 = "987654321";
        System.out.println(addStrings_415_2.addStrings(num1, num2));
    }
}
