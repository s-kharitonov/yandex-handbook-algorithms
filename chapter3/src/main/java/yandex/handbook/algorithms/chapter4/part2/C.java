package yandex.handbook.algorithms.chapter4.part2;

import java.io.*;

/**
 * <h1>
 *      A+B строки
 * </h1>
 * <p>
 *      Необходимо вычислить "кривую" сумму двух строк A и B одинаковой длины.
 *      "Кривой" суммой двух строк называется операция следующего вида:
 *      C = A + B = A1B1A2B2...An-1Bn-1AnBn
 *      Где n - длина строк A и B
 * </p>
 * <p>
 *      Формат ввода
 *      <br/>
 *      В первой строке записано целое число n (1 <= n <= 10). Вторая строка содержит строку A.
 *      Третья строка содержит строку B.
 * </p>
 * <p>
 *      Формат вывода
 *      <br/>
 *      Выведите одну строку, содержащую строку C = A + B
 * </p>
 */
public class C {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());
            var a = reader.readLine();
            var b = reader.readLine();
            var result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                var currentAChar = a.charAt(i);
                var currentBChar = b.charAt(i);

                result.append(currentAChar);
                result.append(currentBChar);
            }

            writer.write(result.toString());
        }
    }

}
