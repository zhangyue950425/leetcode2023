package offer;

public class MinArray {

    public int minArray(int[] numbers) {
        int length = numbers.length;
        int start = 0, end = length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (numbers[mid] > numbers[end]) {
                start = mid + 1;
            } else if (numbers[mid] < numbers[end]) {
                end = mid;
            } else {
                end--;
            }
        }
        return numbers[start];
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3,4,5,6,1,2,3};
        MinArray minArray = new MinArray();
        System.out.println(minArray.minArray(numbers));
    }
}
