package cylong.lambda;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamTest {

    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);

        doFor(numList);
        doStream(numList);
        doParallelStream(numList);
    }

    private static void doFor(List<Integer> numList) {
        long start = System.currentTimeMillis();
        for (int num : numList) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(num);
        }
        System.out.println();
        long stop = System.currentTimeMillis();
        System.out.println("doFor: " + (stop - start));
    }

    private static void doStream(List<Integer> numList) {
        long start = System.currentTimeMillis();
        numList.stream().forEach(num -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(num);
        });
        System.out.println();
        long stop = System.currentTimeMillis();
        System.out.println("doStream: " + (stop - start));
    }

    private static void doParallelStream(List<Integer> numList) {
        long start = System.currentTimeMillis();
        numList.parallelStream().forEach(num -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(num);
        });
        System.out.println();
        long stop = System.currentTimeMillis();
        System.out.println("doParallelStream: " + (stop - start));
    }
}
