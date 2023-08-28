package yandex.handbook.algorithms.chapter5.part1;

import java.io.*;

/**
 * <h1>
 *      Огромное число Фибоначчи
 * </h1>
 * <p>
 *     Даны целые числа n и m, необходимо найти остаток от деления n-го числа Фибоначчи на m,
 * </p>
 * <p>
 *      Формат ввода
 * <br/>
 *      Целые числа n и m.
 *      Ограничения: 1 <= n <= 10^14, 2 <= m <= 10^3
 * </p>
 * <p>
 *      Формат вывода
 * <br/>
 *      Fn mod m - остаток от деления Fn на m
 * </p>
 */
public class C {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            String[] numbers = reader.readLine()
                    .split(" ");
            var n = Long.parseLong(numbers[0]);
            var m = Integer.parseInt(numbers[1]);
            var matrix = new int[][] {
                    {0, 1},
                    {1, 1}
            };
            var matrixExponent = matrixExponentiation(matrix, n, m);

            writer.write(String.valueOf(matrixExponent[0][1]));
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
