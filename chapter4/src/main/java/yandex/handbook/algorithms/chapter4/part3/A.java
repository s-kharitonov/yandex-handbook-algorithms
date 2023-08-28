package yandex.handbook.algorithms.chapter4.part3;

import java.io.*;
import java.util.Arrays;

/**
 * <h1>
 *      Максимальное произведение
 * </h1>
 * <p>
 *      Дана последовательность неотрицательных целых чисел a1, ..., an.
 *      Вычислите max ai * aj, 1 <= i != j <= n
 *      Обратите внимание, что i и j должны быть разными, хотя в каких-то случаях можно наблюдать, ai = aj
 * </p>
 * <p>
 *      Формат ввода
 * <br/>
 *      Первая строка содержит целое число n. Следующая строка содержит n неотрицательных целых чисел а1, ..., an (разделены пробелами)
 *      Ограничения 2 <= n <= 2 * 10^5; 0 <= a1, ..., an <= 2 * 10^5
 * </p>
 * <p>
 *      Формат вывода
 * <br/>
 *      Максимальное попарное произведение
 * </p>
 */
public class A {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());
            long[] numbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();

            var firstMaxValue = Math.max(numbers[0], numbers[1]);
            var secondMaxValue = Math.min(numbers[0], numbers[1]);

            if (numbers.length == 2) {
                writer.write(String.valueOf(firstMaxValue * secondMaxValue));
                return;
            }

            for (var i = 2; i < n; i++) {
                var current = numbers[i];

                if (current > firstMaxValue) {
                    secondMaxValue = firstMaxValue;
                    firstMaxValue = current;
                } else if (current > secondMaxValue) {
                    secondMaxValue = current;
                }
            }

            writer.write(String.valueOf(firstMaxValue * secondMaxValue));
        }
    }

}
