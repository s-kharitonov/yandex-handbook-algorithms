package yandex.handbook.algorithms.chapter5.part1;

import java.io.*;

/**
 * <h1>
 *      Последняя цифра суммы чисел Фибоначчи
 * </h1>
 * <p>
 *     Даны числа m и n, необходимо найти последнюю цифру суммы Fm + Fm + 1 ... + Fn
 * </p>
 * <p>
 *      Формат ввода
 * <br/>
 *      Целые числа m и n.
 *      Ограничения: 0 <= m <= n <= 10^14
 * </p>
 * <p>
 *      Формат вывода
 * <br/>
 *      Последняя цифра суммы Fm + Fm + 1 ... + Fn
 * </p>
 */
public class E {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            String[] numbers = reader.readLine()
                    .split(" ");
            var n = Long.parseLong(numbers[1]);
            var m = Long.parseLong(numbers[0]);
            var matrixN = new int[][]{
                    {0, 1},
                    {1, 1}
            };
            var matrixM = new int[][]{
                    {0, 1},
                    {1, 1}
            };
            var matrixExponentN = matrixExponentiation(matrixN, n + 2, 10);
            var matrixExponentM = matrixExponentiation(matrixM, m + 1, 10);
            var lastDigit = ((matrixExponentN[0][1] + 10) - matrixExponentM[0][1]) % 10;

            writer.write(String.valueOf(lastDigit));
        }
    }

    public static int[][] matrixExponentiation(int[][] matrix, long exponent, int module) {
        if (exponent == 0) {
            return new int[][]{
                    {1, 0},
                    {0, 1},
            };
        }

        if (exponent % 2 == 0) {
            var result = matrixExponentiation(matrix, exponent / 2, module);

            return multiplyMatrix(result, result, module);
        }

        var result = matrixExponentiation(matrix, (exponent - 1) / 2, module);

        return multiplyMatrix(multiplyMatrix(result, result, module), matrix, module);
    }

    public static int[][] multiplyMatrix(int[][] first, int[][] second, int module) {
        int[][] result = new int[first.length][second.length];

        result[0][0] = (first[0][0] * second[0][0] + first[0][1] * second[1][0]) % module;
        result[0][1] = (first[0][0] * second[0][1] + first[0][1] * second[1][1]) % module;
        result[1][0] = (first[1][0] * second[0][0] + first[1][1] * second[1][0]) % module;
        result[1][1] = (first[1][0] * second[0][1] + first[1][1] * second[1][1]) % module;

        return result;
    }

}
