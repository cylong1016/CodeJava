package cylong.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListTest {

    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 普通的 for 循环
        for (int n : numList) {
            System.out.println(n);
        }

        // 使用 Lambda 表达式
        numList.forEach(n -> System.out.println(n));

        // 使用 Java 8 的方法引用
        // 看起来像C++的作用域解析运算符
        numList.forEach(System.out::println);

        // 输出集合中所有大于5的值
        numList.stream().filter(n -> n > 5).forEach(System.out::println);

        // 输出集合中所有大于5并且小于8的值
        Predicate<Integer> start = n -> n >=5;
        Predicate<Integer> end = n -> n <=8;
        numList.stream().filter(start.and(end)).forEach(System.out::println);

        // 将集合中的所有值计算平方后输出
        numList.stream().map(n -> n * n).forEach(System.out::println);

        // 将集合中的所有值求和
        int result = numList.stream().reduce((sum, n) -> sum + n).get();
        System.out.println(result);

        // 创建一个新的集合，所有元素的值大于5
        List<Integer> newNumList = numList.stream().filter(n -> n > 5).collect(Collectors.toList());
        newNumList.forEach(System.out::print);
        System.out.println();
        numList.forEach(System.out::print);
        System.out.println();

        // 计算集合元素的最大值、最小值、总和以及平均值
        IntSummaryStatistics stats = numList.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }

}
