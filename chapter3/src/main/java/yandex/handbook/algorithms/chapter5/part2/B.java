package yandex.handbook.algorithms.chapter5.part2;

import java.io.*;
import java.util.Arrays;

/**
 * <h1>
 *      Наименьшее общее кратное
 * </h1>
 * <p>
 *     Для двух чисел a и b найдите их наименьшее общее кратное.
 * </p>
 * <p>
 *      Формат ввода
 * <br/>
 *      Целые числа a и b(разделённые пробелом).
 *      Ограничения: 1 <= a, b <= 2 * 10^9
 * </p>
 * <p>
 *      Формат вывода
 * <br/>
 *      Наименьшее общее кратное чисел a и b
 * </p>
 */
public class B {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            long[] numbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            var a = numbers[0];
            var b = numbers[1];
            var lcm = (a * b) / gcd(a, b);

            writer.write(String.valueOf(lcm));
        }
    }

    public static long gcd(long a, long b) {
        while (a > 0 && b > 0) {
            if (a >= b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        return Math.max(a, b);
    }

}
