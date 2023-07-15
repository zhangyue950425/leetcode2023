package ByteDancePractice;

public class Candy_135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candys = new int[n];
        for (int i = 0; i < n; i++) {
            candys[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            }
        }
        int[] candys2 = new int[n];
        for (int i = 0; i < n; i++) {
            candys2[i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candys2[i] = candys2[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + Math.max(candys[i], candys2[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        Candy_135 candy135 = new Candy_135();
        int[] ratings = new int[] {1, 0, 2};
        System.out.println(candy135.candy(ratings));
        ratings = new int[] {1,2,2};
        System.out.println(candy135.candy(ratings));
        ratings = new int[] {1,3,2,2,1};
        System.out.println(candy135.candy(ratings));
        ratings = new int[] {1,2,87,87,87,2,1};
        System.out.println(candy135.candy(ratings));
    }
}
