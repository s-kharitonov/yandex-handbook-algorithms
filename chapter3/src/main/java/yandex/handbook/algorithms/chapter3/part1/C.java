package yandex.handbook.algorithms.chapter3.part1;

import java.io.*;

/**
 * <h1>
 *     Сочетания с повторениями
 * </h1>
 * <p>
 *     Выведите число сочетаний c повторением C(n,k).
 * </p>
 * <p>
 *     Формат ввода
 *     <br/>
 *     В первой строке находится два числа (1 ≤ n ≤ 4), (1 ≤ k ≤ 4).
 * </p>
 * <p>
 *     Формат вывода
 *     <br/>
 *     Выведите ответ на задачу.
 * </p>
 */
public class C {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var numbers = reader.readLine()
                    .split(" ");
            var n = Integer.parseInt(numbers[0]);
            var k = Integer.parseInt(numbers[1]);
            var result = factorial(k + n - 1) / (factorial(n - 1) * factorial(k));

            writer.write(String.valueOf(result));
        }
    }

    private static int factorial(int number) {
        var result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        return result;
    }

}
