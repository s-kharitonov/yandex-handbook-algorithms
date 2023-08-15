package yandex.handbook.algorithms.chapter3.part4;

import java.io.*;

/**
 * <h1>
 * Ханойские башни 2
 * </h1>
 * <p>
 * Головоломка <<Ханойские башни>> состоит из трёх стержней, пронумеруем их слева направо: 1, 2 и 3.
 * Также в головоломке используется стопка дисков с отверстием посередине. Радиус дисков уменьшается снизу вверх.
 * Изначально диски расположены на левом стержне (стержень 1), самый большой диск находится внизу.
 * Диски в игре перемещаются по одному со стержня на стержень.
 * Диск можно надеть на стержень, только если он пустой или верхний диск на нём большего размера, чем перемещаемый.
 * Цель головоломки — перенести все диски со стержня 1 на стержень 3.
 * <p>
 * Немного изменим правила. Теперь головоломка состоит из четырех стержней,
 * а цель головоломки — перенести все диски со стержня 1 на стержень 4.
 * Найдите минимальное количество ходов, за которое можно решить головоломку.
 * </p>
 * <p>
 * Формат ввода
 * <br/>
 * В первой строке задано одно число (3 ≤ n ≤ 10) — количество дисков на первой башне.
 * </p>
 * <p>
 * Формат вывода
 * <br/>
 * В единственной строке выведите ответ на задачу.
 * </p>
 */
public class B {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());
            var stepsCount = calculateStepsCountForResolveHanoiTowers(n);

            writer.write(String.valueOf(stepsCount));
        }
    }

    public static int calculateStepsCountForResolveHanoiTowers(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        var k = (int) (Math.sqrt(1 + 8 * n) - 1) / 2;

        return calculateStepsCountForResolveHanoiTowers(n - k) * 2 + (int) Math.pow(2, k) - 1;
    }

}
