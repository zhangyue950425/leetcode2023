package learning.Java;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * 使用Guava的布隆过滤器
 */
public class GuavaBloomFilter {
    public static void main(String[] args) {
        // 创建布隆过滤器对象
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),
                1500, 0.01);
        // 判断指定元素是否存在
        System.out.println(bloomFilter.mightContain(1));
        System.out.println(bloomFilter.mightContain(2));
        // 将元素添加进布隆过滤器
        bloomFilter.put(1);
        bloomFilter.put(2);
        System.out.println(bloomFilter.mightContain(1));
        System.out.println(bloomFilter.mightContain(2));

    }
}
