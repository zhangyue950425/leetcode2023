package BinarySearch;

public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int h1 = calHour(piles, mid);
            if (h1 > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int calHour(int[] piles, int k) {
        int h = 0;
        for (int i = 0;i < piles.length; i++) {
            h += piles[i] / k;
            if (piles[i] % k != 0) {
                h++;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        // piles = [3,6,7,11], h = 8
        int[] piles = new int[]{3,6,7,11};
        int h = 8;
        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
        System.out.println(minEatingSpeed.minEatingSpeed(piles, h));
        // piles = [30,11,23,4,20], h = 5
        piles = new int[]{30,11,23,4,20};
        h = 5;
        System.out.println(minEatingSpeed.minEatingSpeed(piles, h));
        // piles = [30,11,23,4,20], h = 6
        piles = new int[]{30,11,23,4,20};
        h = 6;
        System.out.println(minEatingSpeed.minEatingSpeed(piles, h));
    }
}
