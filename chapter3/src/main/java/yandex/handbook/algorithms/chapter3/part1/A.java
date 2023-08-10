package yandex.handbook.algorithms.chapter3.part1;

import java.io.*;

/**
 * <h1>
 *     Перестановки
 * </h1>
 * <p>
 *     Выведите число перестановок P(n).
 * </p>
 * <p>
 *     Формат ввода
 *     <br/>
 *     В первой строке находится одно число (1 ≤ n ≤ 7)
 * </p>
 * <p>
 *     Формат вывода
 *     <br/>
 *     Выведите ответ на задачу.
 * </p>
 */
public class A {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var number = Integer.parseInt(reader.readLine());
            var result = 1;

            for (int i = 1; i <= number; i++) {
                result *= i;
            }

            writer.write(String.valueOf(result));
        }
    }

}
