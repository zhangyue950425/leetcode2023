package ByteDancePractice;

public class AddStrings_415 {

    public String addStrings(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int[] int1 = new int[length1];
        int[] int2 = new int[length2];
        int i = length1 - 1;
        for (Character c : num1.toCharArray()) {
            int1[i--] = c - '0';
        }
        i = length2 - 1;
        for (Character c : num2.toCharArray()) {
            int2[i--] = c - '0';
        }
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int index1 = 0, index2 = 0;
        while (index1 < length1 || index2 < length2) {
            int n1 = 0;
            if (index1 < length1) {
                n1 = int1[index1];
            }
            int n2 = 0;
            if (index2 < length2) {
                n2 = int2[index2];
            }
            int sum = n1 + n2 + carry;
            carry = 0;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }
            stringBuilder.append(sum);
            index1++;
            index2++;
        }
        if (carry > 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings_415 addStrings415 = new AddStrings_415();
        String num1 = "11";
        String num2 = "123";
        System.out.println(addStrings415.addStrings(num1, num2));
        num1 = "1";
        num2 = "9";
        System.out.println(addStrings415.addStrings(num1, num2));
        num1 = "456";
        num2 = "77";
        System.out.println(addStrings415.addStrings(num1, num2));
    }
}
