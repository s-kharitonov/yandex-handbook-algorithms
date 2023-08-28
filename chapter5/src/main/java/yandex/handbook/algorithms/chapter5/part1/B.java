package yandex.handbook.algorithms.chapter5.part1;

import java.io.*;

/**
 * <h1>
 *      Последняя цифра числа Фибоначчи
 * </h1>
 * <p>
 *     Дано число n, необходимо найти последнюю цифру n-го числа Фибоначчи.
 *     Числа Фибоначчи растут очень быстро, поэтому при их вычислении нужно быть аккуратным с переполнением.
 *     В данной задаче, впрочем, этой проблемы можно избежать, поскольку нас интересует только последняя цифра числа
 *     Фибоначчи: если 0 <= a,b <= 9 последние цифры чисел Fi и Fi+1 соответственно, то (a + b)mod10 - последняя цифра
 *     числа Fi+2.
 * </p>
 * <p>
 *      Формат ввода
 * <br/>
 *      Целое число n.
 *      Ограничения: 0 <= n <= 10^6
 * </p>
 * <p>
 *      Формат вывода
 * <br/>
 *      Последняя цифра из Fn
 * </p>
 */
public class B {

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
                previous = currentF % 10;
            }

            writer.write(String.valueOf(previous));
        }
    }

}
