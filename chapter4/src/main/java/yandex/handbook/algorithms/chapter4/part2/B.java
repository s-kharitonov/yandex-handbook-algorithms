package yandex.handbook.algorithms.chapter4.part2;

import java.io.*;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * <h1>
 *      A(x) + B(x)
 * </h1>
 * <p>
 *      Решите немного более сложную задачу.
 *      Необходимо вычислить сумму двух многочленов A(x) = an * x^n + ... + a1 + x + a0 и B(x) = bm * x^m + ... + b1 + x + b0
 * </p>
 * <p>
 *      Формат ввода
 *      <br/>
 *      В первой строке записано одно целое число n (0 <= n <= 10).
 *      <br/>
 *      В второй строке записаны числа an, an-1, ..., a0 (-100 <= ai <= 100, an != 0).
 *      <br/>
 *      В третьей строке записано одно целое число m (0 <= m <= 10).
 *      <br/>
 *      В четвертой строке записаны числа bm, bm-1, ..., b0 (-100 <= bi <= 100, bm != 0).
 *      <br/>
 *      Гарантируется, что an + bm != 0.
 * </p>
 * <p>
 *      Формат вывода
 *      <br/>
 *      В первой строке выведите число k - cтепень многочлена A(x) + B(x).
 *      В второй строке выведите коэффициенты этого многочлена ck, ck-1, ..., c1, c0.
 * </p>
 */
public class B {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());
            int[] aNumbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var m = Integer.parseInt(reader.readLine());
            int[] bNumbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            writer.write(Math.max(n, m) + System.lineSeparator());

            for (int i = aNumbers.length - 1, j = bNumbers.length - 1; i >= 0 && j >= 0; i--, j--) {
                var currentA = aNumbers[i];
                var currentB = bNumbers[j];
                var sum = currentA + currentB;

                aNumbers[i] = sum;
                bNumbers[j] = sum;
            }

            if (bNumbers.length >= aNumbers.length) {
                var result = formatNumbers(bNumbers);

                writer.write(result);
            } else {
                var result = formatNumbers(aNumbers);

                writer.write(result);
            }
        }
    }

    private static String formatNumbers(int[] bNumbers) {
        return Arrays.stream(bNumbers)
                .mapToObj(String::valueOf)
                .collect(joining(" "));
    }

}
