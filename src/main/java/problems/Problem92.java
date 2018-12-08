package problems;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * A number chain is created by continuously adding the square of the digits in a number to form a new number
 * until it has been seen before.
 * <p>
 * For example,
 * <p>
 * 44 → 32 → 13 → 10 → 1 → 1
 * 85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89
 * <p>
 * Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop.
 * What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.
 * <p>
 * How many starting numbers below ten million will arrive at 89?
 */
class Problem92 {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();
        IntStream
                .rangeClosed(1, 10_000_000)
                .parallel()
                .forEach(i ->
                        processNextNumber(i, atomicInteger));

        System.out.println(atomicInteger);

    }

    private static void processNextNumber(int counter, AtomicInteger atomicInteger) {
        int sum = counter;
        while (sum != 89 && sum != 1)
            sum = squareAndSumDigits(sum);
        if (sum == 89)
            atomicInteger.incrementAndGet();
    }

    public static int squareAndSumDigits(int digits) {
        int sum = 0;
        while (digits > 0) {
            sum += (digits % 10) * (digits % 10);
            digits /= 10;
        }
        return sum;
    }

}
