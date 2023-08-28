package yandex.handbook.algorithms.chapter4.part2;

import java.io.*;
import java.util.Arrays;

/**
 * <h1>
 *      A + B
 * </h1>
 * <p>
 *      Задача-разминка: найдите сумму двух чисел.
 * </p>
 * <p>
 *      Формат ввода
 * <br/>
 *      Целые числа a и b на одной строке (разделенные пробелом)
 *      Ограничения 0 <= a,b <= 9
 * </p>
 * <p>
 *      Формат вывода
 * <br/>
 *      Сумма a и b
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

            writer.write(String.valueOf(numbers[0] + numbers[1]));
        }
    }

}
