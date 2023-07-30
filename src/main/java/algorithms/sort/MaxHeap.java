package algorithms.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 堆结构
 */
public class MaxHeap {



    private List<Integer> maxHeap;

    /**
     * 构造方法，根据输入列表建堆
     */
    MaxHeap(List<Integer> nums) {
        // 将列表元素原封不动添加进堆
        maxHeap = new ArrayList<>(nums);
        // 堆化除叶节点以外的其他所有节点
        for (int i = parent(size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    private Queue<Integer> topKHeap(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            int num = queue.peek();
            if (num < nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue;
    }

    /**
     * 获取左子节点索引
     * 获取索引值为i的元素的左子节点的索引值
     */
    private int left(int i) {
        return 2 * i + 1;
    }

    /**
     * 获取右子节点索引
     * 获取索引值为i的元素的右子节点的索引值
     */
    private int right(int i) {
        return 2 * i + 2;
    }

    /**
     * 获取父节点
     * 获取索引值为i的元素的父节点的索引值
     * 向下整除
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * 访问堆顶元素
     */
    private int peek() {
        return maxHeap.get(0);
    }

    /**
     * 元素入堆
     * 新插入的元素放置堆底
     * 从该节点开始从底到顶开始堆化处理，和父节点比较，如果大于父节点需要交换
     */
    private void push(int val) {
        // 添加节点
        maxHeap.add(val);
        // 从底至顶堆化
        siftUp(maxHeap.size() - 1);
    }

    /**
     * 从节点 i 开始，从底至顶堆化
     * @param i
     */
    private void siftUp(int i) {
        while (true) {
            int parent = parent(i);
            // 无需交换
            if (parent < 0 || maxHeap.get(i) <= maxHeap.get(parent)) {
                break;
            }
            swap(i, parent);
            i = parent;
        }
    }

    private int size() {
        return maxHeap.size();
    }

    private int pop() {
        if (maxHeap.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        // 换根节点与最右叶节点（即交换首元素与尾元素）
        swap(0, size() - 1);
        // 删除节点
        int val = maxHeap.remove(size() - 1);
        // 从顶至底堆化
        siftDown(0);
        // 返回堆顶元素
        return val;
    }

    /**
     * 从节点 i 开始，从顶至底堆化
     * 需要比较i索引值和左右子节点对应的索引值，最大的和i位置的值交换，如果i索引位置就是最大值无需交换则结束
     * @param i
     */
    private void siftDown(int i) {
        while (true) {
            int left = left(i), right = right(i);
            // 假设最大节点值是i索引位置的值
            int max = i;
            if (left < size() && maxHeap.get(left) > maxHeap.get(max)) {
                max = left;
            }
            if (right < size() && maxHeap.get(right) > maxHeap.get(max)) {
                max = right;
            }
            // i位置就是最大的值无需交换
            if (max == i) {
                break;
            }
            swap(i, max);
            i = max;
        }
    }

    private void swap(int index1, int index2) {
        int num1 = maxHeap.get(index1);
        int num2 = maxHeap.get(index2);
        maxHeap.set(index1, num2);
        maxHeap.set(index2, num1);
    }
}
