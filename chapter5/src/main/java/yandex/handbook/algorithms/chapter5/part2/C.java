package yandex.handbook.algorithms.chapter5.part2;

import java.io.*;

/**
 * <h1>
 *      Наибольшее число шагов алгоритма Евклида
 * </h1>
 * <p>
 *     Алгоритм Евклида можно записать в рекурсивной форме:
 *     <pre>{@code
 *          GCD(a, b):
 *              if a = 0 or b = 0:
 *                  return max(a,b)
 *              return GCD(b,a mod b)
 *     }</pre>
 *     Вызов функции GCD(5, 0) не порождает дополнительных рекурсивных вызовов. А вызов GCD(5, 2) - порождает вызовы
 *     GCD(2, 1) и GCD(1, 0). Количество шагов алгоритма Евклида будет равняться количеству вызовов функции GCD
 *     для заданных значений a и b. Дано число n, найдите значения a и b (0 <= a, b <= n) для которых количество вызовов
 *     функции GCD будет наибольшим.
 * </p>
 * <p>
 *      Формат ввода
 * <br/>
 *      Целое число n.
 *      Ограничения: 1 <= n <= 10^9
 * </p>
 * <p>
 *      Формат вывода
 * <br/>
 *      Значения a и b (разделённые пробелом).
 *      Если существует несколько пар значений a и b, для которых количество вызовов функции GCD наибольшее,
 *      то выведите любую из таких пар.
 * </p>
 */
public class C {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());

            if (n == 1) {
                writer.write("1 1");
                return;
            }

            var a = 1;
            var b = 0;

            while (a + b <= n) {
                if (a > b) {
                    b += a;
                } else {
                    a += b;
                }
            }

            writer.write(Math.min(a, b) + " " + Math.max(a, b));
        }
    }

}
