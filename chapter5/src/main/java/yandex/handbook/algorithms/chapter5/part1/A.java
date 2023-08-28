package yandex.handbook.algorithms.chapter5.part1;

import java.io.*;

/**
 * <h1>
 *      Числа Фибоначчи
 * </h1>
 * <p>
 *     Дано целое число n, необходимо вычислить n-e число Фибоначчи.
 *     Напомним, что F0 = 0, F1 = 1, Fn = Fn-1 + Fn-2, при n >= 2
 * </p>
 * <p>
 *      Формат ввода
 * <br/>
 *      Целое число n.
 *      Ограничения: 0 <= n <= 45
 * </p>
 * <p>
 *      Формат вывода
 * <br/>
 *      Выведите Fn
 * </p>
 */
public class A {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());

            if (n < 2) {
                writer.write(String.valueOf(n));
                return;
            }

            var prevPrevious = 0;
            var previous = 1;

            for (int i = 2; i <= n; i++) {
                var currentF = prevPrevious + previous;

                prevPrevious = previous;
                previous = currentF;
            }

            writer.write(String.valueOf(previous));
        }
    }

}
