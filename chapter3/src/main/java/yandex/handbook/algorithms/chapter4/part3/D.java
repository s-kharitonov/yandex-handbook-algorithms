package yandex.handbook.algorithms.chapter4.part3;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * <h1>
 *      Максимальное произведение четырех чисел
 * </h1>
 * <p>
 *      Дана последовательность целых чисел a1, ..., an.
 *      Вычислите max ai * aj * ak * al, 1 <= i != j != k != l <= n
 *      Обратите внимание, что i, j, k, l должны быть разными, хотя в каких-то случаях можно наблюдать, ai = al
 * </p>
 * <p>
 *      Формат ввода
 * <br/>
 *      Первая строка содержит целое число n. Следующая строка содержит n целых чисел а1, ..., an (разделены пробелами)
 *      Ограничения 4 <= n <= 2 * 10^5; -2 * 10^5 <= a1, ..., an <= 2 * 10^5
 * </p>
 * <p>
 *      Формат вывода
 * <br/>
 *      Максимальное произведение четырех элементов
 * </p>
 */
public class D {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());
            BigInteger[] numbers = Arrays.stream(reader.readLine().split(" "))
                    .map(BigInteger::new)
                    .toArray(BigInteger[]::new);

            if (n == 4) {
                var first = numbers[0];
                var second = numbers[1];
                var third = numbers[2];
                var fourth = numbers[3];
                var multiplication = first.multiply(second)
                        .multiply(third)
                        .multiply(fourth);

                writer.write(String.valueOf(multiplication));
                return;
            }

            kthStatisticsAndSwap(numbers, 0, n - 1, n - 5);
            kthStatisticsAndSwap(numbers, 0, n - 1, n - 3);
            kthStatisticsAndSwap(numbers, 0, n - 1, 2);
            kthStatisticsAndSwap(numbers, 0, n - 1, 4);

            var top4Multiplication = numbers[n - 1].multiply(numbers[n - 2])
                    .multiply(numbers[n - 3])
                    .multiply(numbers[n - 4]);
            var low4Multiplication = numbers[0].multiply(numbers[1])
                    .multiply(numbers[2])
                    .multiply(numbers[3]);
            var top2AndLow2Multiplication = numbers[0].multiply(numbers[1])
                    .multiply(numbers[n - 1])
                    .multiply(numbers[n - 2]);

            if (top4Multiplication.compareTo(low4Multiplication) > 0 && top4Multiplication.compareTo(top2AndLow2Multiplication) > 0) {
                writer.write(top4Multiplication.toString());
                return;
            }

            if (low4Multiplication.compareTo(top4Multiplication) > 0 && low4Multiplication.compareTo(top2AndLow2Multiplication) > 0) {
                writer.write(low4Multiplication.toString());
                return;
            }

            writer.write(top2AndLow2Multiplication.toString());
        }
    }

    private static void kthStatisticsAndSwap(BigInteger[] numbers, int left, int right, int k) {
        if (left >= right) {
            return;
        }

        var pivot = partition(numbers, left, right);

        if (k < pivot) {
            kthStatisticsAndSwap(numbers, left, pivot - 1, k);
        } else {
            kthStatisticsAndSwap(numbers, pivot, right, k);
        }
    }

    private static int partition(BigInteger[] numbers, int left, int right) {
        var pivot = numbers[left + (right - left) / 2];

        while (left <= right) {
            while (numbers[left].compareTo(pivot) < 0) {
                left++;
            }

            while (numbers[right].compareTo(pivot) > 0) {
                right--;
            }

            if (left <= right) {
                swap(numbers, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private static void swap(BigInteger[] numbers, int from, int to) {
        var prevValue = numbers[from];

        numbers[from] = numbers[to];
        numbers[to] = prevValue;
    }
}
