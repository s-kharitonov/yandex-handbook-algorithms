package yandex.handbook.algorithms.chapter3.part3;

import java.io.*;

/**
 * <h1>
 * Камни 2
 * </h1>
 * <p>
 * Вы играете в игру <<Камни>>: игру для двух игроков с двумя наборами камней по n и m штук.
 * С каждым ходом один игрок может забрать следующие комбинации камней:
 *      <ul>
 *          <li>Взять один камень из любого набора.</li>
 *          <li>Взять два камня из какого-то одного набора</li>
 *          <li>Взять два камня из одного и один из другого.</li>
 *      </ul>
 *      Когда камень забрали, он выходит из игры. Побеждает игрок, который заберет последний камень. Первый ход за вами.
 *      Вы и ваш оппонент играете оптимально
 * </p>
 * <p>
 *      Формат ввода
 *      <br/>
 *      В первой строке содержится два числа n (1 ≤ n ≤ 10), m (1 ≤ m ≤ 10) — количество ваших камней
 *      и количество камней у вашего оппонента.
 * </p>
 * <p>
 *      Формат вывода
 *      <br/>
 *      В единственной строке выведите Loose, если вы заведомо проиграете, и Win, иначе.
 * </p>
 */
public class B {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            String[] numbers = reader.readLine()
                    .split(" ");
            var n = Integer.parseInt(numbers[0]);
            var m = Integer.parseInt(numbers[1]);
            var matrix = makeMatrix(n + 1, m + 1);

            writer.write(matrix[n][m]);
        }
    }

    private static String[][] makeMatrix(int n, int m) {
        var matrix = new String[n][m];

        matrix[0][0] = "Loose";

        fillFirstColumn(n, matrix);
        fillFirstRow(m, matrix);

        for (var i = 1; i < n; i++) {
            for (var j = 1; j < m; j++) {
                var isLeftElementWinner = "Win".equals(matrix[i - 1][j]);
                var isLeftAndTopElementWinner = "Loose".equals(matrix[i - 1][j - 1]);
                var isTopElementWinner = "Win".equals(matrix[i][j - 1]);

                if (isLeftElementWinner && isLeftAndTopElementWinner && isTopElementWinner) {
                    matrix[i][j] = "Loose";
                } else {
                    matrix[i][j] = "Win";
                }
            }
        }

        return matrix;
    }

    private static void fillFirstRow(int m, String[][] matrix) {
        for (var j = 1; j < m; j++) {
            if (j % 3 == 0) {
                matrix[0][j] = "Loose";
            } else {
                matrix[0][j] = "Win";
            }
        }
    }

    private static void fillFirstColumn(int n, String[][] matrix) {
        for (var i = 1; i < n; i++) {
            if (i % 3 == 0) {
                matrix[i][0] = "Loose";
            } else {
                matrix[i][0] = "Win";
            }
        }
    }

}