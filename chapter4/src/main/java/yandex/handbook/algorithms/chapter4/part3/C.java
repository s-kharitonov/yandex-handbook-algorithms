package yandex.handbook.algorithms.chapter4.part3;

import java.io.*;
import java.util.Arrays;

/**
 * <h1>
 *      Максимальное произведение трех чисел
 * </h1>
 * <p>
 *      Дана последовательность целых чисел a1, ..., an.
 *      Вычислите max ai * aj * ak, 1 <= i != j, i != k, j != k <= n
 *      Обратите внимание, что i, j, k должны быть разными, хотя в каких-то случаях можно наблюдать, ai = aj
 * </p>
 * <p>
 *      Формат ввода
 * <br/>
 *      Первая строка содержит целое число n. Следующая строка содержит n целых чисел а1, ..., an (разделены пробелами)
 *      Ограничения 3 <= n <= 2 * 10^5; -2 * 10^5 <= a1, ..., an <= 2 * 10^5
 * </p>
 * <p>
 *      Формат вывода
 * <br/>
 *      Максимальное произведение трех элементов
 * </p>
 */
public class C {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());
            long[] numbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();

            if (n == 3) {
                writer.write(String.valueOf(numbers[0] * numbers[1] * numbers[2]));
                return;
            }

            kthStatisticsAndSwap(numbers, 0, n - 1, n - 1);
            kthStatisticsAndSwap(numbers, 0, n - 2, n - 2);
            kthStatisticsAndSwap(numbers, 0, n - 3, 2);

            var last3NumbersMultiplication = numbers[n - 1] * numbers[n - 2] * numbers[n - 3];
            var first2NumbersAndLastMultiplication = numbers[0] * numbers[1] * numbers[n - 1];
            var maxValue = Math.max(last3NumbersMultiplication, first2NumbersAndLastMultiplication);

            writer.write(String.valueOf(maxValue));
        }
    }

    public static void kthStatisticsAndSwap(long[] numbers, int left, int right, int k) {
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

    private static int partition(long[] numbers, int left, int right) {
        var pivot = numbers[left + (right - left) / 2];

        while (left <= right) {
            while (numbers[left] < pivot) {
                left++;
            }

            while (numbers[right] > pivot) {
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

    private static void swap(long[] numbers, int from, int to) {
        var prevValue = numbers[from];

        numbers[from] = numbers[to];
        numbers[to] = prevValue;
    }

}
