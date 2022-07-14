package array;

import java.util.*;

/**
 * 380
 */
public class RandomizedSet {
    private List<Integer> nums;
    private Map<Integer, Integer> valToIndex;

    private Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        int index = valToIndex.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index, last);
        valToIndex.put(last, index);
        nums.remove(nums.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        // ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
        // [[], [1], [2], [2], [], [1], [2], []]
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}
