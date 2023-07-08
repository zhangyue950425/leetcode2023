package ByteDancePractice;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman_12 {
    /**
     * 暴力法
     * @param num
     * @return
     */
    Map<Integer, String> map = new HashMap<>();
    {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }
        public String intToRoman(int num) {
        if (num < 10) {
            return unitsDigit(num);
        } else if (num == 10) {
            return map.get(10);
        } else if (num < 50) {
            if (num == 40) {
                return map.get(40);
            } else {
                return twoNum(num);
            }
        } else if (num == 50) {
            return map.get(50);
        } else if (num < 100) {
            if (num == 90) {
                return map.get(90);
            } else {
                return twoNum(num);
            }
        } else if (num == 100) {
            return map.get(100);
        } else if (num < 500) {
            if (num == 400) {
                return map.get(400);
            } else {
                return hundredsDigit(num) + twoNum(num % 100);
            }
        } else if (num == 500) {
            return map.get(500);
        } else if (num < 1000) {
            if (num == 900) {
                return map.get(900);
            } else {
                return hundredsDigit(num) + twoNum(num % 100);
            }
        } else if (num == 1000) {
            return map.get(1000);
        } else {
            int num1 = num % 1000;
            int num2 = num1 % 100;
            return thousands(num) + hundredsDigit(num1) + twoNum(num2);
        }
    }

    /**
     * 贪心算法
     * map.put(1, "I");
     *         map.put(4, "IV");
     *         map.put(5, "V");
     *         map.put(9, "IX");
     *         map.put(10, "X");
     *         map.put(40, "XL");
     *         map.put(50, "L");
     *         map.put(90, "XC");
     *         map.put(100, "C");
     *         map.put(400, "CD");
     *         map.put(500, "D");
     *         map.put(900, "CM");
     *         map.put(1000, "M");
     * @param num
     * @return
     */
    public String intToRoman2(int num) {
        // 降序数组，优先使用最大值
        int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strings = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index < 13) {
            while (num >= nums[index]) {
                stringBuilder.append(strings[index]);
                num = num - nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }

    private String unitsDigit(int num) {
        if (num == 4 || num == 9) {
            return map.get(num);
        } else {
            if (num < 4) {
                StringBuilder stringBuffer = new StringBuilder();
                for (int i = 0; i < num; i++) {
                    stringBuffer.append(map.get(1));
                }
                return stringBuffer.toString();
            } else {
                int re = num - 5;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(map.get(5));
                for (int i = 0; i < re; i++) {
                    stringBuilder.append(map.get(1));
                }
                return stringBuilder.toString();
            }
        }
    }
    private String tensDigit(int num) {
        int n = num / 10;
        if (n == 4) {
            return map.get(40);
        }
        if (n == 9) {
            return map.get(90);
        }
        if (n == 5) {
            return map.get(50);
        }
        if (num > 50) {
            int num1 = num - 50;
            n = num1 / 10;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(map.get(50));
            for (int i = 0; i < n; i++) {
                stringBuilder1.append(map.get(10));
            }
            return stringBuilder1.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(map.get(10));
        }
        return stringBuilder.toString();
    }

    private String hundredsDigit(int num) {
        int n = num / 100;
        if (n == 4) {
            return map.get(400);
        }
        if (n == 9) {
            return map.get(900);
        }
        if (n == 5) {
            return map.get(500);
        }
        if (num > 500) {
            int num1 = num - 500;
            n = num1 / 100;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(map.get(500));
            for (int i = 0; i < n; i++) {
                stringBuilder1.append(map.get(100));
            }
            return stringBuilder1.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(map.get(100));
        }
        return stringBuilder.toString();
    }

    private String thousands(int num) {
        int n = num / 1000;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(map.get(1000));
        }
        return stringBuilder.toString();
    }

    private String twoNum(int num) {
        int re = num % 10;
        num = num - re;
        return tensDigit(num) + unitsDigit(re);
    }

    public static void main(String[] args) {
        IntToRoman_12 intToRoman12 = new IntToRoman_12();
        int num = 3;
        System.out.println(intToRoman12.intToRoman(num));
        System.out.println(intToRoman12.intToRoman2(num));
        num = 4;
        System.out.println(intToRoman12.intToRoman(num));
        System.out.println(intToRoman12.intToRoman2(num));
        num = 9;
        System.out.println(intToRoman12.intToRoman(num));
        System.out.println(intToRoman12.intToRoman2(num));
        num = 58;
        System.out.println(intToRoman12.intToRoman(num));
        System.out.println(intToRoman12.intToRoman2(num));
        num = 358;
        System.out.println(intToRoman12.intToRoman(num));
        System.out.println(intToRoman12.intToRoman2(num));
        num = 585;
        System.out.println(intToRoman12.intToRoman(num));
        System.out.println(intToRoman12.intToRoman2(num));
        num = 1994;
        System.out.println(intToRoman12.intToRoman(num));
        System.out.println(intToRoman12.intToRoman2(num));
        num = 3858;
        System.out.println(intToRoman12.intToRoman(num));
        System.out.println(intToRoman12.intToRoman2(num));
    }
}
