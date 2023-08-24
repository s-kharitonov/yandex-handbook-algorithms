package yandex.handbook.algorithms.chapter4.part2;

import java.io.*;
import java.util.Arrays;

/**
 * <h1>
 *      A+B матрицы
 * </h1>
 * <p>
 *      Необходимо вычислить сумму двух матриц C = A + B
 * </p>
 * <p>
 *      Формат ввода
 *      <br/>
 *      В первой строке записано два целых числа n и m (1 <= n, m <= 10).
 *      Далее идут n строк, каждая содержит по m чисел, описание элементов матрицы A (-100 <= Ai,j <= 100)
 *      Далее идут n строк, каждая содержит по m чисел, описание элементов матрицы B (-100 <= Bi,j <= 100)
 * </p>
 * <p>
 *      Формат вывода
 *      <br/>
 *      Выведите n строк, каждая содержащая по m чисел, описание элементов матрицы С.
 * </p>
 */
public class D {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int[] matrixSize = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var n = matrixSize[0];
            var m = matrixSize[1];
            int[][] aMatrix = new int[n][m];

            for (int i = 0; i < n; i++) {
                var line = reader.readLine()
                        .split(" ");

                for (int j = 0; j < line.length; j++) {
                    var current = Integer.parseInt(line[j]);

                    aMatrix[i][j] = current;
                }
            }

            for (int i = 0; i < n; i++) {
                var line = reader.readLine()
                        .split(" ");
                var lastIndex = line.length - 1;

                for (int j = 0; j < line.length; j++) {
                    var current = Integer.parseInt(line[j]);
                    var sum = current + aMatrix[i][j];


                    if (j == lastIndex) {
                        writer.write(sum + System.lineSeparator());
                    } else {
                        writer.write(sum + " ");
                    }
                }
            }

        }
    }

}
