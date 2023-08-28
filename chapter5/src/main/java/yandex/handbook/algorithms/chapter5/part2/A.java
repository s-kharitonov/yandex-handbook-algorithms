package yandex.handbook.algorithms.chapter5.part2;

import java.io.*;
import java.util.Arrays;

/**
 * <h1>
 *      Наибольший общий делитель
 * </h1>
 * <p>
 *     Для двух чисел a и b найдите их наибольший общий делитель.
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
 *      Наибольший общий делитель чисел a и b
 * </p>
 */
public class A {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int[] numbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var a = numbers[0];
            var b = numbers[1];

            while (a > 0 && b > 0) {
                if (a >= b) {
                    a = a % b;
                } else {
                    b = b % a;
                }
            }

            writer.write(String.valueOf(Math.max(a, b)));
        }
    }

}
